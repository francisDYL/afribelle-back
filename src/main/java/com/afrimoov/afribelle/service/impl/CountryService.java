package com.afrimoov.afribelle.service.impl;

import com.afrimoov.afribelle.domain.Country;
import com.afrimoov.afribelle.dto.CountryDto;
import com.afrimoov.afribelle.dto.SearchCriteria;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.mapper.CountryMapper;
import com.afrimoov.afribelle.repository.CountryRepository;
import com.afrimoov.afribelle.repository.specifications.CountrySpecification;
import com.afrimoov.afribelle.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService extends AbstractService implements ICountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public CountryService(@Autowired CountryRepository repository,
                   @Autowired CountryMapper mapper) {
        this.countryRepository = repository;
        this.countryMapper = mapper;
    }

    @Override
    public List<CountryDto> createCountries(List<CountryDto> countries) {
        List<Country> toCreate = new ArrayList<>();
        for(CountryDto countryDto: countries) {
            Country country = countryMapper.toEntity(countryDto);
            toCreate.add(country);
        }
        List<Country> created = countryRepository.saveAll(toCreate);
        return countryMapper.toDto(created);
    }

    @Override
    public List<CountryDto> updateCountries(List<CountryDto> countries) throws NotFoundException {
        List<Country> toUpdate = new ArrayList<>();
        for(CountryDto countryDto: countries) {
            Optional<Country> optionalCountry = countryRepository.findById(countryDto.getId());
            if(!optionalCountry.isPresent()) throw new NotFoundException(String.format("Country with id %d not found",countryDto.getId()));

            Country country = countryMapper.updateEntity(optionalCountry.get(), countryDto);
            toUpdate.add(country);
        }
        List<Country> updated = countryRepository.saveAll(toUpdate);
        return countryMapper.toDto(updated);
    }

    @Override
    public List<Long> deleteCountries(List<Long> countries) {
        countryRepository.deleteAllById(countries);
        return countries;
    }

    @Override
    public Page<CountryDto> getAll(Pageable pageable) {

        Page<Country> page = countryRepository.findAll(pageable);

        return page.map(countryMapper::toDto);
    }

    @Override
    public CountryDto getById(Long id) throws NotFoundException {
        Optional<Country> optionalCountry = countryRepository.findById(id);
        if(!optionalCountry.isPresent()) throw new NotFoundException(String.format("Country with id %d not found",id));

        return countryMapper.toDto(optionalCountry.get());
    }

    @Override
    public Page<CountryDto> findByCriteria(List<SearchCriteria> criterias, Pageable pageable) {
        final Page<Country> page = countryRepository.findAll(new CountrySpecification(toSpecifications(criterias)), pageable);
        return page.map(countryMapper::toDto);
    }
}
