package com.afrimoov.afribelle.service;

import com.afrimoov.afribelle.dto.EventDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEventService {

    List<EventDto> saveAll(List<EventDto> events);

    Page<EventDto> getAll(Pageable pageable);
}
