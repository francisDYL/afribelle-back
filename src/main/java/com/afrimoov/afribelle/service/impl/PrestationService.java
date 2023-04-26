package com.afrimoov.afribelle.service.impl;

import com.afrimoov.afribelle.domain.Prestation;
import com.afrimoov.afribelle.dto.PrestationDto;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.mapper.PrestationMapper;
import com.afrimoov.afribelle.repository.PrestationRepository;
import com.afrimoov.afribelle.service.IPrestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PrestationService extends AbstractService implements IPrestationService {

    private final PrestationRepository prestationRepository;
    private final PrestationMapper prestationMapper;

    public PrestationService (@Autowired PrestationRepository repository,
                          @Autowired PrestationMapper mapper) {
        this.prestationRepository = repository;
        this.prestationMapper = mapper;
    }

    
    @Override
    public Page<PrestationDto> getAll(Pageable pageable) {
        Page<Prestation> page = prestationRepository.findAll(pageable);
        return page.map(prestationMapper::toDto);
    }

    @Override
    public PrestationDto getById(Long id) throws NotFoundException {
        Optional<Prestation> optionalPrestation = prestationRepository.findById(id);
        if(!optionalPrestation.isPresent())
            throw new NotFoundException(String.format("Prestation with id %d not found",id));
        return prestationMapper.toDto(optionalPrestation.get());
    }

    @Override
    public Page<PrestationDto> getByUserId(Long userId, Pageable pageable) {
        Page<Prestation> page = prestationRepository.findByUser(userId, pageable);
        return page.map(prestationMapper::toDto);
    }

    @Override
    public Page<PrestationDto> getByName(String name, Pageable pageable) {
        Page<Prestation> page = prestationRepository.findByName(name, pageable);
        return page.map(prestationMapper::toDto);
    }

    @Override
    public Page<PrestationDto> getByContryId(Long countryId, Pageable pageable) {
        Page<Prestation> page = prestationRepository.findByCountryId(countryId, pageable);
        return page.map(prestationMapper::toDto);
    }

    @Override
    public Page<PrestationDto> getByCityId(Long cityId, Pageable pageable) {
       Page<Prestation> page = prestationRepository.findByCityId(cityId, pageable);
        return page.map(prestationMapper::toDto);
    }

    @Override
    public Page<PrestationDto> getByDistrictId(Long districtId, Pageable pageable) {
        Page<Prestation> page = prestationRepository.findByDistrictId(districtId, pageable);
        return page.map(prestationMapper::toDto);
    }

    @Override
    public Page<PrestationDto> getByAdresseId(Long adresseId, Pageable pageable) {
        Page<Prestation> page = prestationRepository.findByAddressId(adresseId, pageable);
        return page.map(prestationMapper::toDto);
    }

    @Override
    public List<PrestationDto> savePrestations(List<PrestationDto> prestations) {
        List<Prestation> toSave = new ArrayList<>();
        for(PrestationDto prestationDto : prestations) {
            toSave.add(prestationMapper.toEntity(prestationDto));
        }

        List<Prestation> saved = prestationRepository.saveAll(toSave);
        return prestationMapper.toDto(saved);
    }

    @Override
    public List<PrestationDto> updatePrestations(List<PrestationDto> prestations) throws NotFoundException {
        List<Prestation> toUpdate = new ArrayList<>();
        for(PrestationDto prestationDto : prestations) {
            Optional<Prestation> optionalPrestation = prestationRepository.findById(prestationDto.getId());
            if(!optionalPrestation.isPresent()) throw new NotFoundException(String.format("Prestation with id %d not found",prestationDto.getId()));
            toUpdate.add(prestationMapper.updateEntity(optionalPrestation.get(), prestationDto));
        }

        List<Prestation> updated = prestationRepository.saveAll(toUpdate);
        return prestationMapper.toDto(updated);
    }

    @Override
    public List<Long> deletePrestations(List<Long> pageIds) {
        prestationRepository.deleteAllById(pageIds);
        return pageIds;
    }

    @Override
    public Page<PrestationDto> getByPageId(Long pageId, Pageable pageable) {
        Page<Prestation> page = prestationRepository.findByPageId(pageId, pageable);
        return page.map(prestationMapper::toDto);
    }
}
