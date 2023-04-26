package com.afrimoov.afribelle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CountryDto {
    @JsonProperty("pays_id")
    private Long id;

    @JsonProperty("flag")
    private Long flag;

    @JsonProperty("flag_str")
    private String flagStr;

    @JsonProperty("name")
    private String name;

    @JsonProperty("code")
    private String code;

    @JsonProperty("pgeo_id")
    private Long geographicLocation;

    @JsonProperty("illustration")
    private String illustration;

    @JsonProperty("description")
    private String description;

    private boolean activated;
}
