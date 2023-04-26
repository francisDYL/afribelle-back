package com.afrimoov.afribelle.mapper;

import com.afrimoov.afribelle.domain.City;
import com.afrimoov.afribelle.dto.CityDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PgeoMapper.class})
public interface CityMapper extends AbstractMapper<City, CityDto> {

    default City fromId(Long id) {
        if(id == null) return null;

        City city = new City();
        city.setId(id);

        return city;
    }
}
