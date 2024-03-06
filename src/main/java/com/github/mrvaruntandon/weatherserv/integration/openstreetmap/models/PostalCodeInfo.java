package com.github.mrvaruntandon.weatherserv.integration.openstreetmap.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostalCodeInfo {
    private long place_id;
    private String licence;
    private String lat;
    private String lon;
    @JsonProperty("class")
    private String clazz;
    private String type;
    private int place_rank;
    private double importance;
    private String addresstype;
    private String name;
    private String display_name;
    private String[] boundingbox;
}

