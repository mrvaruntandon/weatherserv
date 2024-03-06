package com.github.mrvaruntandon.weatherserv.integration.openmeteo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecast {
    private double latitude;
    private double longitude;
    @JsonProperty("generationtime_ms")
    private double generationTimeMs;
    @JsonProperty("utc_offset_seconds")
    private int utcOffsetSeconds;
    private String timezone;
    @JsonProperty("timezone_abbreviation")
    private String timezoneAbbreviation;
    private double elevation;
    @JsonProperty("current_units")
    private Units currentUnits;
    private Current current;
    @JsonProperty("daily_units")
    private DailyUnits dailyUnits;
    private Daily daily;

}

