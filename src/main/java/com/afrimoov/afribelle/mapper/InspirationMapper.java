package com.afrimoov.afribelle.mapper;

import com.afrimoov.afribelle.domain.Inspiration;
import com.afrimoov.afribelle.dto.InspirationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InspirationMapper extends AbstractMapper<Inspiration, InspirationDto> {
}
