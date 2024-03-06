package com.github.mrvaruntandon.weatherserv.integration.openmeteo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Units {
    private String time;
    private String interval;
    private String temperature_2m;
}
