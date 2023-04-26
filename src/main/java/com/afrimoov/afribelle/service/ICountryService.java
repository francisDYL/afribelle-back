package com.afrimoov.afribelle.service;

import com.afrimoov.afribelle.dto.CountryDto;
import com.afrimoov.afribelle.dto.SearchCriteria;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICountryService {

    List<CountryDto> createCountries(List<CountryDto> countries);

    List<CountryDto> updateCountries(List<CountryDto> countries) throws NotFoundException;

    List<Long> deleteCountries(List<Long> countries);

    Page<CountryDto> getAll(Pageable pageable);

    CountryDto getById(Long id) throws NotFoundException;

    Page<CountryDto> findByCriteria(List<SearchCriteria> criterias, Pageable pageable);
}
