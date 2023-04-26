package com.afrimoov.afribelle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PageDto extends BaseItemDto {

    @JsonProperty("country")
    private CountryDto country;

    @JsonProperty("city")
    private CityDto ville;

    @JsonProperty("quartier")
    private DistrictDto quartier;

    @JsonProperty("adresse")
    private AddressDto adresse;
}
