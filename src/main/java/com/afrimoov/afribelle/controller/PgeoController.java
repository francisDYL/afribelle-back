package com.afrimoov.afribelle.controller;

import com.afrimoov.afribelle.dto.PgeoDto;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.service.IPgeoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pgeos")
@Slf4j
public class PgeoController {

    @Autowired
    IPgeoService pgeoService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<PgeoDto>> getAll(@RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(pgeoService.getAll(pageable));
    }


    @GetMapping(value = "/getPgeoById")
    public ResponseEntity<PgeoDto> getById(@RequestParam(name="id") Long id) throws NotFoundException {
        return ResponseEntity.ok(pgeoService.getById(id));
    }

    @PostMapping(value = "/savePgeos")
    public ResponseEntity<List<PgeoDto>> save(@RequestBody List<PgeoDto> pgeos) {

        return ResponseEntity.ok(pgeoService.createPgeos(pgeos));
    }

    @PutMapping(value = "/updatePgeos")
    public ResponseEntity<List<PgeoDto>> update(@RequestBody List<PgeoDto> pgeos) throws NotFoundException {

        return ResponseEntity.ok(pgeoService.updatePgeos(pgeos));
    }

    @DeleteMapping(value = "/deletePgeos")
    public ResponseEntity<List<Long>> deletePages(@RequestBody List<Long> pgeos) {
        return ResponseEntity.ok(pgeoService.deletePgeos(pgeos));
    }
}
