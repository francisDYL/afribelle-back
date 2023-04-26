package com.afrimoov.afribelle.service;

import com.afrimoov.afribelle.dto.CityDto;
import com.afrimoov.afribelle.dto.SearchCriteria;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICityService {

    List<CityDto> createCities(List<CityDto> cities);

    List<CityDto> updateCities(List<CityDto> cities) throws NotFoundException;

    List<Long> deleteCities(List<Long> cities);

    Page<CityDto> getAll(Pageable pageable);

    CityDto getById(Long id) throws NotFoundException;

    List<CityDto> findByContry(Long countryId);

    CityDto findByPgeo(Long pgeoId) throws NotFoundException;

    Page<CityDto> findByCriteria(List<SearchCriteria> criterias, Pageable pageable);
}
