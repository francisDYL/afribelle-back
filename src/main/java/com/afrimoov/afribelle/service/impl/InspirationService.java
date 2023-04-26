package com.afrimoov.afribelle.service.impl;

import com.afrimoov.afribelle.domain.Address;
import com.afrimoov.afribelle.domain.Inspiration;
import com.afrimoov.afribelle.dto.AddressDto;
import com.afrimoov.afribelle.dto.InspirationDto;
import com.afrimoov.afribelle.dto.SearchCriteria;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.mapper.InspirationMapper;
import com.afrimoov.afribelle.repository.InspirationRepository;
import com.afrimoov.afribelle.repository.specifications.InspirationSpecification;
import com.afrimoov.afribelle.service.IInspirationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InspirationService extends AbstractService implements IInspirationService {

    private final InspirationRepository inspirationRepository;
    private final InspirationMapper inspirationMapper;

    public InspirationService (@Autowired InspirationRepository repository,
                               @Autowired InspirationMapper mapper) {
        this.inspirationRepository = repository;
        this.inspirationMapper = mapper;
    }

    @Override
    public List<InspirationDto> savesInspirations(List<InspirationDto> inspirations) {
        List<Inspiration> toCreate = new ArrayList<>();
        for (InspirationDto inspirationDto: inspirations) {
            Inspiration address = inspirationMapper.toEntity(inspirationDto);
            toCreate.add(address);
        }

        List<Inspiration> created = inspirationRepository.saveAll(toCreate);
        return inspirationMapper.toDto(created);
    }

    @Override
    public List<InspirationDto> updatesInspirations(List<InspirationDto> inspirations) throws NotFoundException {
        List<Inspiration> toUpdate = new ArrayList<>();

        for (InspirationDto inspirationDto: inspirations) {
            Optional<Inspiration> optionalInspiration = inspirationRepository.findById(inspirationDto.getId());
            if(!optionalInspiration.isPresent())
                throw new NotFoundException(String.format("Inspiration with id %d not found", inspirationDto.getId()));

            Inspiration address = inspirationMapper.updateEntity(optionalInspiration.get(), inspirationDto);
            toUpdate.add(address);
        }

        List<Inspiration> updated = inspirationRepository.saveAll(toUpdate);
        return inspirationMapper.toDto(updated);
    }

    @Override
    public List<Long> deleteInspirations(List<Long> inspirationsIds) {
        inspirationRepository.deleteAllById(inspirationsIds);
        return inspirationsIds;
    }

    @Override
    public Page<InspirationDto> getAll(Pageable pageable) {
        Page<Inspiration> page = inspirationRepository.findAll(pageable);
        return page.map(inspirationMapper::toDto);
    }

    @Override
    public InspirationDto findById(Long id) throws NotFoundException {
        Optional<Inspiration> optionalInspiration = inspirationRepository.findById(id);
        if(!optionalInspiration.isPresent())
            throw new NotFoundException(String.format("Inspiration with id %d not found", id));
        return inspirationMapper.toDto(optionalInspiration.get());
    }

    @Override
    public Page<InspirationDto> findByCriteria(List<SearchCriteria> criterias, Pageable pageable) {
        Page<Inspiration> page = inspirationRepository.findAll(new InspirationSpecification(toSpecifications(criterias)),pageable);
        return page.map(inspirationMapper::toDto);
    }
}
