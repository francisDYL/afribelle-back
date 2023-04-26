package com.afrimoov.afribelle.mapper;

import com.afrimoov.afribelle.domain.Prestation;
import com.afrimoov.afribelle.dto.PrestationDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;

@Mapper(componentModel = "spring",
        mappingInheritanceStrategy = MappingInheritanceStrategy.EXPLICIT)
public interface PrestationMapper extends AbstractMapper<Prestation, PrestationDto> {
}
