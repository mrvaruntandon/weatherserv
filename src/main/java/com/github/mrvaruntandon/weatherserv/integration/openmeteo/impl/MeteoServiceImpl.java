package com.github.mrvaruntandon.weatherserv.integration.openmeteo.impl;

import com.github.mrvaruntandon.weatherserv.integration.MeteoIntegration;
import com.github.mrvaruntandon.weatherserv.integration.openmeteo.models.WeatherForecast;
import com.github.mrvaruntandon.weatherserv.models.Current;
import com.github.mrvaruntandon.weatherserv.models.Daily;
import com.github.mrvaruntandon.weatherserv.models.Temperature;
import com.github.mrvaruntandon.weatherserv.models.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class MeteoServiceImpl implements MeteoIntegration {
    private static final String API_URL = "https://api.open-meteo.com/v1/forecast?latitude={latitude}&longitude={longitude}&current=temperature_2m&daily=temperature_2m_max,temperature_2m_min&forecast_days=1";

    @Override
    public WeatherResponse getWeather(String latitude, String longitude) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<WeatherForecast> responseEntity = restTemplate.getForEntity(API_URL, WeatherForecast.class, latitude, longitude);
            return map(responseEntity.getBody());
        } catch (Exception e) {
            log.error("Error occurred while fetching weather forecast: {}", e.getMessage());
            return null;
        }
    }

    private WeatherResponse map(WeatherForecast weatherData){
        WeatherResponse response = new WeatherResponse();
        response.setCurrent(
                Current.builder()
                        .time(weatherData.getCurrent().getTime().toString())
                        .temperature(Temperature.builder().unit(weatherData.getCurrentUnits().getTemperature_2m()).value(weatherData.getCurrent().getTemperature2m()).build())
                        .build()
        );
        response.setDaily(
                Daily.builder()
                        .time(weatherData.getDaily().getTime().get(0))
                        .maxTemperature(Temperature.builder().value(weatherData.getDaily().getTemperature_2m_max().get(0)).unit(weatherData.getDailyUnits().getTemperature_2m_max()).build())
                        .minTemperature(Temperature.builder().value(weatherData.getDaily().getTemperature_2m_min().get(0)).unit(weatherData.getDailyUnits().getTemperature_2m_min()).build())
                        .build()
        );
        response.setFromCache(false);
        return response;
    }
}
