package com.afrimoov.afribelle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PgeoDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("lat")
    private Double latitude;

    @JsonProperty("long")
    private Double longitude;

    @JsonProperty("lat_deg")
    private Double latDeg;

    @JsonProperty("long_deg")
    private Double longDeg;
}
