package com.afrimoov.afribelle.controller;

import com.afrimoov.afribelle.dto.EventDto;
import com.afrimoov.afribelle.service.IEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/event-services")
@Slf4j
public class EventController {

    @Autowired
    IEventService eventService;

    @GetMapping(value = "/saveEvents")
    public ResponseEntity<List<EventDto>> saveAll(@RequestBody List<EventDto> events) {

        return ResponseEntity.ok(eventService.saveAll(events));
    }

    @GetMapping(value = "/getEvents")
    public ResponseEntity<Page<EventDto>> getAll(@RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                 @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(eventService.getAll(pageable));
    }

}
