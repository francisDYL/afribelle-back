package com.afrimoov.afribelle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductDto extends BaseSaleItemDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("prestation_id")
    private Long prestionId;

    @JsonProperty("country")
    private Long country;

    @JsonProperty("city")
    private Long ville;

    @JsonProperty("quartier")
    private Long quartier;

    @JsonProperty("adresse")
    private Long adresse;


}
