package com.afrimoov.afribelle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddressDto implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("quartier_id")
    private Long quartierId;

    @JsonProperty("quartier_name")
    private String quartierName;

    @JsonProperty("city_id")
    private Long villeId;

    @JsonProperty("city_name")
    private String villeName1;

    @JsonProperty("country_id")
    private Long paysId;

    @JsonProperty("country_name")
    private String paysName;

    @JsonProperty("rue")
    private String rue;

    @JsonProperty("numero")
    private Long numero;

    @JsonProperty("descrription")
    private String description;

    @JsonProperty("pgeo")
    private Long geographicLocation;

    @JsonProperty("format_str")
    private String formatStr;
}
