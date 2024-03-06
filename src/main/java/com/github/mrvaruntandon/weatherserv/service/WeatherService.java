package com.github.mrvaruntandon.weatherserv.service;

import com.github.mrvaruntandon.weatherserv.models.WeatherResponse;

public interface WeatherService {
    WeatherResponse getWeather(String postalCode, String countryCode);
}
