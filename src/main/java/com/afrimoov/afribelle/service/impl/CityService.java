package com.afrimoov.afribelle.service.impl;

import com.afrimoov.afribelle.domain.City;
import com.afrimoov.afribelle.dto.CityDto;
import com.afrimoov.afribelle.dto.SearchCriteria;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.mapper.CityMapper;
import com.afrimoov.afribelle.repository.CityRepository;
import com.afrimoov.afribelle.repository.PgeoRepository;
import com.afrimoov.afribelle.repository.specifications.CitySpecification;
import com.afrimoov.afribelle.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityService extends AbstractService implements ICityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public CityService(@Autowired CityRepository cityRepository,
                       @Autowired CityMapper cityMapper) {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
    }

    @Override
    public List<CityDto> createCities(List<CityDto> cities) {

        List<City> toCreate = new ArrayList<>();
        for(CityDto cityDto: cities) {
            //TODO est-ce qu'on check le pays et la position geographique
            City city = cityMapper.toEntity(cityDto);
            toCreate.add(city);
        }
        List<City> created = cityRepository.saveAll(toCreate);
        return cityMapper.toDto(created);
    }

    @Override
    public List<CityDto> updateCities(List<CityDto> cities) throws NotFoundException {
        List<City> toUpdate = new ArrayList<>();

        for(CityDto cityDto: cities) {
            Optional<City> optionalCity = cityRepository.findById(cityDto.getId());
            if(!optionalCity.isPresent()) throw new NotFoundException(String.format("City with id %d not found",cityDto.getId()));

            City city = cityMapper.updateEntity(optionalCity.get(), cityDto);

            toUpdate.add(city);
        }
        List<City> updated = cityRepository.saveAll(toUpdate);
        return cityMapper.toDto(updated);
    }

    @Override
    public List<Long> deleteCities(List<Long> cities) {
        cityRepository.deleteAllById(cities);
        return cities;
    }

    @Override
    public Page<CityDto> getAll(Pageable pageable) {
        Page<City> cities = cityRepository.findAll(pageable);
        return cities.map(cityMapper::toDto);
    }

    @Override
    public CityDto getById(Long id) throws NotFoundException {
        Optional<City> optionalCity = cityRepository.findById(id);
        if(!optionalCity.isPresent()) throw new NotFoundException(String.format("City with id %d not found",id));

        return cityMapper.toDto(optionalCity.get());
    }

    @Override
    public List<CityDto> findByContry(Long countryId) {
        List<City> cities = cityRepository.findByPaysId(countryId);

        return cityMapper.toDto(cities);
    }

    @Override
    public CityDto findByPgeo(Long pgeoId) throws NotFoundException {
        Optional<City> optionalCity = cityRepository.findByPgeoId(pgeoId);
        if (!optionalCity.isPresent()) throw new NotFoundException(String.format("No city found for the location with id %",pgeoId));

        return cityMapper.toDto(optionalCity.get());
    }

    @Override
    public Page<CityDto> findByCriteria(List<SearchCriteria> criterias, Pageable pageable) {
        Page<City> cities = cityRepository.findAll( new CitySpecification(toSpecifications(criterias)), pageable);
        return cities.map(cityMapper::toDto);
    }
}
