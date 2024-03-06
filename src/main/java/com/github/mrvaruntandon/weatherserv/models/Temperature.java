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
    "value",
    "unit"
})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Temperature implements Serializable {

    @JsonProperty("value")
    private Double value;
    @JsonProperty("unit")
    private String unit;

}
