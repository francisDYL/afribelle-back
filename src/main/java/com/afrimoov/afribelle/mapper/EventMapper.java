package com.afrimoov.afribelle.mapper;

import com.afrimoov.afribelle.domain.Event;
import com.afrimoov.afribelle.dto.EventDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper extends AbstractMapper<Event, EventDto> {
}
