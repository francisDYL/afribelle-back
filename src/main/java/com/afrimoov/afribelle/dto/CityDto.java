package com.afrimoov.afribelle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CityDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("country_id")
    private Long paysId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("country_name")
    private String paysName;

    @JsonProperty("pgeo")
    private PgeoDto pgeo;

    @JsonProperty("illustration")
    private String illustration;

    @JsonProperty("description")
    private String description;
}
