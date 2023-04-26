package com.afrimoov.afribelle.service.impl;

import com.afrimoov.afribelle.domain.Event;
import com.afrimoov.afribelle.dto.EventDto;
import com.afrimoov.afribelle.mapper.EventMapper;
import com.afrimoov.afribelle.repository.EventRepository;
import com.afrimoov.afribelle.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService implements IEventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public EventService(@Autowired EventRepository eventRepository,
                        @Autowired EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    @Override
    public List<EventDto> saveAll(List<EventDto> events) {
        List<Event> toCreate = new ArrayList<>();
        for(EventDto eventDto: events) {
            Event event = eventMapper.toEntity(eventDto);
            toCreate.add(event);
        }

        List<Event> created = eventRepository.saveAll(toCreate);

        return eventMapper.toDto(created);
    }

    @Override
    public Page<EventDto> getAll(Pageable pageable) {
        Page<Event> page = eventRepository.findAll(pageable);

        return page.map(eventMapper::toDto);
    }
}
