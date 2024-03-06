package com.github.mrvaruntandon.weatherserv.integration;

import java.util.Map;

public interface MapIntegration {
    Map.Entry<String, String> getLatitudeAndLongitude(String postalCode, String countryCode);
}
