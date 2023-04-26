package com.afrimoov.afribelle.service.impl;

import com.afrimoov.afribelle.domain.District;
import com.afrimoov.afribelle.dto.DistrictDto;
import com.afrimoov.afribelle.dto.SearchCriteria;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.mapper.DistrictMapper;
import com.afrimoov.afribelle.repository.DistrictRepository;
import com.afrimoov.afribelle.repository.specifications.DistrictSpecification;
import com.afrimoov.afribelle.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DistricService extends AbstractService implements IDistrictService {

    private final DistrictRepository districtRepository;
    private final DistrictMapper districtMapper;

    public DistricService(@Autowired DistrictRepository repository,
                          @Autowired DistrictMapper mapper) {
        this.districtRepository = repository;
        this.districtMapper = mapper;
    }

    @Override
    public List<DistrictDto> createDistricts(List<DistrictDto> districtDtos) {
        List<District> toCreate = new ArrayList<>();
        for(DistrictDto districtDto: districtDtos) {
            District district = districtMapper.toEntity(districtDto);
            toCreate.add(district);
        }

        List<District> created = districtRepository.saveAll(toCreate);

        return districtMapper.toDto(created);
    }

    @Override
    public List<DistrictDto> updateDistricts(List<DistrictDto> districtDtos) throws NotFoundException {
        List<District> toUpdate = new ArrayList<>();
        for(DistrictDto districtDto: districtDtos) {
            Optional<District> optionalDistrict = districtRepository.findById(districtDto.getId());
            if(!optionalDistrict.isPresent()) throw new NotFoundException(String.format("District with id %d not found",districtDto.getId()));
            District district = districtMapper.updateEntity(optionalDistrict.get(), districtDto);
            toUpdate.add(district);
        }

        List<District> updated = districtRepository.saveAll(toUpdate);

        return districtMapper.toDto(updated);
    }

    @Override
    public List<Long> deleteDistricts(List<Long> districtIds) {
        districtRepository.deleteAllById(districtIds);
        return districtIds;
    }

    @Override
    public Page<DistrictDto> getAll(Pageable pageable) {
        Page<District> page = districtRepository.findAll(pageable);
        return page.map(districtMapper::toDto);
    }

    @Override
    public DistrictDto findById(Long id) throws NotFoundException {
        Optional<District> optionalDistrict = districtRepository.findById(id);
        if(!optionalDistrict.isPresent()) throw new NotFoundException(String.format("District with id %d not found",id));

        return districtMapper.toDto(optionalDistrict.get());
    }

    @Override
    public Page<DistrictDto> findByCriteria(List<SearchCriteria> criterias, Pageable pageable) {
        Page<District> page = districtRepository.findAll(new DistrictSpecification(toSpecifications(criterias)), pageable);

        return  page.map(districtMapper::toDto);
    }

    @Override
    public DistrictDto findByLocationId(Long pgeoId) throws NotFoundException {
       Optional<District> optionalDistrictDto = districtRepository.findByGeographicLocation(pgeoId);
       if(!optionalDistrictDto.isPresent()) throw new NotFoundException(String.format("No District for location with id %d not found",pgeoId));

       return districtMapper.toDto(optionalDistrictDto.get());
    }
}
