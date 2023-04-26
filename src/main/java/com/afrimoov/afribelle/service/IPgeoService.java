package com.afrimoov.afribelle.service;

import com.afrimoov.afribelle.dto.PgeoDto;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPgeoService {

    List<PgeoDto> createPgeos(List<PgeoDto> pgeos);

    List<PgeoDto> updatePgeos(List<PgeoDto> pgeos) throws NotFoundException;

    List<Long> deletePgeos(List<Long> pgeos);

    Page<PgeoDto> getAll(Pageable pageable);

    PgeoDto getById(Long id) throws NotFoundException;
}
