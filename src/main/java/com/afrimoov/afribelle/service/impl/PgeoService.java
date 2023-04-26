package com.afrimoov.afribelle.service.impl;

import com.afrimoov.afribelle.domain.Pgeo;
import com.afrimoov.afribelle.dto.PgeoDto;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.mapper.PgeoMapper;
import com.afrimoov.afribelle.repository.PgeoRepository;
import com.afrimoov.afribelle.service.IPgeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PgeoService implements IPgeoService {
    
    private final PgeoRepository pgeoRepository;
    private final PgeoMapper mapper;
    
    PgeoService(@Autowired PgeoRepository repository,
                @Autowired PgeoMapper mapper) {
        this.pgeoRepository = repository;
        this.mapper = mapper;
    }
    
    @Override
    public List<PgeoDto> createPgeos(List<PgeoDto> pgeos) {
        List<Pgeo> toCreate = mapper.toEntity(pgeos);
        List<Pgeo> createdPgeo = pgeoRepository.saveAll(toCreate);
        return mapper.toDto(createdPgeo);
    }

    @Override
    public List<PgeoDto> updatePgeos(List<PgeoDto> pgeos) throws NotFoundException {
        List<Pgeo> toUpdate = new ArrayList<>();

        for(PgeoDto pgeoDto: pgeos) {
            Optional<Pgeo> pgeoOptional = pgeoRepository.findById(pgeoDto.getId());
            if(!pgeoOptional.isPresent())
                throw new NotFoundException(String.format("Pgeo with id %d not found",pgeoDto.getId()));
            Pgeo pgeo = pgeoOptional.get();
            mapper.updateEntity(pgeo, pgeoDto);
            toUpdate.add(pgeo);
        }

        List<Pgeo> updated = pgeoRepository.saveAll(toUpdate);
        return mapper.toDto(updated);
    }

    @Override
    public List<Long> deletePgeos(List<Long> pgeos) {
        pgeoRepository.deleteAllById(pgeos);
        return pgeos;
    }

    @Override
    public Page<PgeoDto> getAll(Pageable pageable) {
        Page<Pgeo> page =  pgeoRepository.findAll(pageable);
        return page.map(mapper::toDto);
    }

    @Override
    public PgeoDto getById(Long id) throws NotFoundException {
        Optional<Pgeo> pgeoOptional = pgeoRepository.findById(id);
        if(!pgeoOptional.isPresent())
            throw new NotFoundException(String.format("Pgeo with id %d not found",id));

        return mapper.toDto(pgeoOptional.get());
    }
}
