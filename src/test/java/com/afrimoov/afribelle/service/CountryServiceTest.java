package com.afrimoov.afribelle.service;

import com.afrimoov.afribelle.domain.Country;
import com.afrimoov.afribelle.dto.CountryDto;
import com.afrimoov.afribelle.mapper.CountryMapper;
import com.afrimoov.afribelle.repository.CountryRepository;
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


public class CountryServiceTest extends AbstractTest {

    ICountryService countryService;
    CountryRepository countryRepository;

    @Autowired
    CountryMapper countryMapper;

    @BeforeEach
    private  void setUp() {
        countryRepository = Mockito.mock(CountryRepository.class);
        countryService = new CountryService(countryRepository, countryMapper);
        when(countryRepository.saveAll(anyList())).thenAnswer( a -> a.getArgument(0));
    }

    @Test
    public void shouldCreateCountryWithRightpgeo(){
        //GIVEN
        ArgumentCaptor<List<Country>> captor = ArgumentCaptor.forClass(List.class);
        List<CountryDto> toCreate = new ArrayList<>();
        CountryDto countryDto = new CountryDto();
        countryDto.setName("Kmer");
        countryDto.setGeographicLocation(1L);
        toCreate.add(countryDto);

        //WHEN
        countryService.createCountries(toCreate);

        //THEN
        verify(countryRepository,times(1)).saveAll(captor.capture());
        Country country = captor.getValue().get(0);
        assertThat(country.getName()).isEqualTo("Kmer");
        assertThat(country.getGeographicLocation()).isNotNull();
        assertThat(country.getGeographicLocation()).isEqualTo(1L);

    }
}
