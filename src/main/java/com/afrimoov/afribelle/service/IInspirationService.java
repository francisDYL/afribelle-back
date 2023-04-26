package com.afrimoov.afribelle.service;

import com.afrimoov.afribelle.dto.InspirationDto;
import com.afrimoov.afribelle.dto.SearchCriteria;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IInspirationService {

    List<InspirationDto> savesInspirations(List<InspirationDto> inspirations);

    List<InspirationDto> updatesInspirations(List<InspirationDto> inspirations) throws NotFoundException;

    List<Long> deleteInspirations(List<Long> inspirationsIds);

    Page<InspirationDto> getAll(Pageable pageable);

    InspirationDto findById(Long id) throws NotFoundException;

    Page<InspirationDto> findByCriteria(List<SearchCriteria> criterias, Pageable pageable);
}
