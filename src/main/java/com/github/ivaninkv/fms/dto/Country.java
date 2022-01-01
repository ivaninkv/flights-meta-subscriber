package com.github.ivaninkv.fms.dto;

import lombok.ToString;

import java.util.Map;

@ToString
public class Country {
    private String code;
    private String name;
    private String currency;
    private Map<String, Object> name_translations;
    private Map<String, Object> cases;
    private String enName;
    private String ruName;
    private boolean isActive = true;

    public void fillNames() {
        this.enName = (String) name_translations.get("en");
        this.ruName = (String) name_translations.get("ru");
    }
}
