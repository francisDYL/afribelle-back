package com.afrimoov.afribelle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DistrictDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("illustration")
    private String illustration;

    @JsonProperty("description")
    private String description;

    @JsonProperty("pgeo_id")
    private Long geographicLocation;

    @JsonProperty("ville_id")
    private Long cityId;

    @JsonProperty("ville_name")
    private String cityName;

    @JsonProperty("country_id")
    private Long paysId;

    @JsonProperty("country_name")
    private String paysName;

    @JsonProperty("format_str")
    private String formatStr;
}
