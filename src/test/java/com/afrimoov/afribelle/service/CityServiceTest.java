package com.afrimoov.afribelle.service;

import com.afrimoov.afribelle.domain.City;
import com.afrimoov.afribelle.domain.Country;
import com.afrimoov.afribelle.dto.CityDto;
import com.afrimoov.afribelle.dto.CountryDto;
import com.afrimoov.afribelle.dto.PgeoDto;
import com.afrimoov.afribelle.mapper.CityMapper;
import com.afrimoov.afribelle.repository.CityRepository;
import com.afrimoov.afribelle.repository.CountryRepository;
import com.afrimoov.afribelle.service.impl.CityService;
import com.afrimoov.afribelle.service.impl.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

public class CityServiceTest extends AbstractTest{

    ICityService cityService;
    CityRepository cityRepository;

    @Autowired
    CityMapper cityMapper;



    @BeforeEach
    private  void setUp() {
        cityRepository = Mockito.mock(CityRepository.class);
        cityService = new CityService(cityRepository, cityMapper);
        when(cityRepository.saveAll(anyList())).thenAnswer( a -> a.getArgument(0));
    }

    @Test
    public void shouldCreateCityWithRightpgeo(){
        //GIVEN
        ArgumentCaptor<List<City>> captor = ArgumentCaptor.forClass(List.class);
        List<CityDto> toCreate = new ArrayList<>();
        PgeoDto pgeoDto = new PgeoDto();
        pgeoDto.setId(1L);
        CityDto cityDto = new CityDto();
        cityDto.setName("Baf");
        cityDto.setPaysId(1L);
        cityDto.setPgeo(pgeoDto);
        toCreate.add(cityDto);

        //WHEN
        cityService.createCities(toCreate);

        //THEN
        verify(cityRepository,times(1)).saveAll(captor.capture());
        City city = captor.getValue().get(0);
        assertThat(city.getName()).isEqualTo("Baf");
        assertThat(city.getPaysId()).isEqualTo(1L);
        assertThat(city.getPgeo()).isNotNull();
        assertThat(city.getPgeo().getId()).isEqualTo(1L);

    }
}
