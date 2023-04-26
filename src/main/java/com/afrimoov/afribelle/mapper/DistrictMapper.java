package com.afrimoov.afribelle.mapper;

import com.afrimoov.afribelle.domain.District;
import com.afrimoov.afribelle.dto.DistrictDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DistrictMapper extends AbstractMapper<District, DistrictDto> {

    default District fromId(Long id) {
        if(id == null) return null;

        District district = new District();
        district.setId(id);

        return district;
    }
}
