package com.afrimoov.afribelle.mapper;

import com.afrimoov.afribelle.domain.Country;
import com.afrimoov.afribelle.dto.CountryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface CountryMapper extends AbstractMapper<Country, CountryDto> {

    default Country fromId(Long id) {
        if(id == null) return null;

        Country country = new Country();
        country.setId(id);

        return country;
    }
}
