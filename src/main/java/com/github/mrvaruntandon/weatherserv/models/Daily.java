package com.github.mrvaruntandon.weatherserv.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "min_temperature",
    "max_temperature",
    "time"
})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Daily implements Serializable {

    @JsonProperty("min_temperature")
    private Temperature minTemperature;
    @JsonProperty("max_temperature")
    private Temperature maxTemperature;
    @JsonProperty("time")
    private String time;

}
