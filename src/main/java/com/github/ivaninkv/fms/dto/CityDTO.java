package com.github.ivaninkv.fms.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CityDTO {
    private String code;
    private String country_code;
    private String name;
    private Map<String, Double> coordinates;
    private String time_zone;
    private Map<String, String> name_translations;
    private String enName;
    private String ruName;
    private boolean isActive = true;

    public void fillNames() {
        this.enName = name_translations.get("en");
        this.ruName = name_translations.get("ru");
    }
}
