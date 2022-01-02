package com.github.ivaninkv.fms.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CountryDTO {
    private String code;
    private String name;
    private String currency;
    private Map<String, String> name_translations;
    private Map<String, String> cases;
    private String enName;
    private String ruName;
    private boolean isActive = true;

    public void fillNames() {
        this.enName = name_translations.get("en");
        this.ruName = name_translations.get("ru");
    }
}
