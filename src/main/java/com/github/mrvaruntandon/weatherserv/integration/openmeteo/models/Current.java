package com.github.mrvaruntandon.weatherserv.integration.openmeteo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Current {
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime time;
    private int interval;
    @JsonProperty("temperature_2m")
    private double temperature2m;
}
