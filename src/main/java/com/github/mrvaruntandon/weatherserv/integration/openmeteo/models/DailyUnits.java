package com.github.mrvaruntandon.weatherserv.integration.openmeteo.models;

import lombok.Data;

@Data
public class DailyUnits {
    private String time;
    private String temperature_2m_max;
    private String temperature_2m_min;
}
