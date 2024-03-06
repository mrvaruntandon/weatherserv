package com.github.mrvaruntandon.weatherserv.integration.openmeteo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Daily {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private List<String> time;
    @JsonProperty("temperature_2m_max")
    private List<Double> temperature_2m_max;
    @JsonProperty("temperature_2m_min")
    private List<Double> temperature_2m_min;
}
