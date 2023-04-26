package com.afrimoov.afribelle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PrestationDto extends BaseSaleItemDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("duration_millisecs")
    private Long duration;

    @JsonProperty("duration_format")
    private String durationStr;

    @JsonProperty("country")
    private Long country;

    @JsonProperty("city")
    private Long ville;

    @JsonProperty("quartier")
    private Long quartier;

    @JsonProperty("adresse")
    private Long adresse;

    @JsonProperty("deplacement")
    private boolean deplacement;
}
