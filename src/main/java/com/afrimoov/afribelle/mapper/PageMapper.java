package com.afrimoov.afribelle.mapper;

import com.afrimoov.afribelle.domain.PageEntity;
import com.afrimoov.afribelle.dto.PageDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;

@Mapper(componentModel = "spring", uses = {CountryMapper.class, CityMapper.class, DistrictMapper.class, AddressMapper.class},
mappingInheritanceStrategy = MappingInheritanceStrategy.EXPLICIT)
public interface PageMapper extends AbstractMapper<PageEntity, PageDto> {
}
