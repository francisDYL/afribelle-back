package com.afrimoov.afribelle.service;

import com.afrimoov.afribelle.dto.DistrictDto;
import com.afrimoov.afribelle.dto.SearchCriteria;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDistrictService {

    List<DistrictDto> createDistricts(List<DistrictDto> districtDtos);

    List<DistrictDto> updateDistricts(List<DistrictDto> districtDtos) throws NotFoundException;

    List<Long> deleteDistricts(List<Long> districtIds);

    Page<DistrictDto> getAll(Pageable pageable);

    DistrictDto findById(Long id) throws NotFoundException;

    Page<DistrictDto> findByCriteria(List<SearchCriteria> criterias, Pageable pageable);

    DistrictDto findByLocationId(Long pgeoId) throws NotFoundException;


}
