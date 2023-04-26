package com.afrimoov.afribelle.mapper;

import com.afrimoov.afribelle.domain.Config;
import com.afrimoov.afribelle.dto.ConfigDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConfigMapper extends AbstractMapper<Config, ConfigDto> {
}
