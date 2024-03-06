package com.github.mrvaruntandon.weatherserv.service.impl;

import com.github.mrvaruntandon.weatherserv.integration.MapIntegration;
import com.github.mrvaruntandon.weatherserv.integration.MeteoIntegration;
import com.github.mrvaruntandon.weatherserv.models.WeatherResponse;
import com.github.mrvaruntandon.weatherserv.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    MapIntegration mapIntegration;

    @Autowired
    MeteoIntegration meteoIntegration;

    @Autowired
    CacheManager cacheManager;

    @Override
    public WeatherResponse getWeather(String postalCode, String countryCode) {
        if(cacheManager.getCache("weatherCache").get(postalCode + " " + countryCode) != null){
            Cache.ValueWrapper responseWrapper =  cacheManager.getCache("weatherCache").get(postalCode + " " + countryCode);
            if (responseWrapper != null && responseWrapper.get() != null) {
                WeatherResponse response = (WeatherResponse) responseWrapper.get();
                response.setFromCache(true);
                return response;
            }
        }
        Map.Entry<String, String> coordinates = mapIntegration.getLatitudeAndLongitude(postalCode, countryCode);
        WeatherResponse response = meteoIntegration.getWeather(coordinates.getKey(), coordinates.getValue());
        cacheManager.getCache("weatherCache").put(postalCode + " " + countryCode, response);
        return response;
    }
}
