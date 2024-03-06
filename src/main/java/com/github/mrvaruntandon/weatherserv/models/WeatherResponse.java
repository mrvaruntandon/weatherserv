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
    "current",
    "daily",
    "from_cache"
})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponse implements Serializable {

    @JsonProperty("current")
    private Current current;
    @JsonProperty("daily")
    private Daily daily;
    @JsonProperty("from_cache")
    private Boolean fromCache;

}
