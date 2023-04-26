package com.afrimoov.afribelle.service;

import com.afrimoov.afribelle.dto.PrestationDto;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPrestationService {
    
    Page<PrestationDto> getAll(Pageable pageable);

    PrestationDto getById(Long id) throws NotFoundException;

    Page<PrestationDto> getByUserId(Long userId, Pageable pageable);

    Page<PrestationDto> getByName(String name, Pageable pageable);

    Page<PrestationDto> getByContryId(Long countryId, Pageable pageable);

    Page<PrestationDto> getByCityId(Long cityId, Pageable pageable);

    Page<PrestationDto> getByDistrictId(Long districtId, Pageable pageable);

    Page<PrestationDto> getByAdresseId(Long adresseId, Pageable pageable);

    Page<PrestationDto> getByPageId(Long pageId, Pageable pageable);

    List<PrestationDto> savePrestations(List<PrestationDto> prestations);

    List<PrestationDto> updatePrestations(List<PrestationDto> prestations)  throws NotFoundException;

    List<Long> deletePrestations(List<Long> pageIds);
}
