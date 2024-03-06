package com.github.mrvaruntandon.weatherserv.integration;

import com.github.mrvaruntandon.weatherserv.models.WeatherResponse;

public interface MeteoIntegration {
    WeatherResponse getWeather(String latitude, String longitude);
}
