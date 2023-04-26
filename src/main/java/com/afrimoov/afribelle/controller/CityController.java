package com.afrimoov.afribelle.controller;

import com.afrimoov.afribelle.dto.CityDto;
import com.afrimoov.afribelle.dto.CountryDto;
import com.afrimoov.afribelle.dto.SearchCriteria;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.service.ICityService;
import com.afrimoov.afribelle.utils.SearchCriteriaUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/villes")
@Slf4j
public class CityController {
    static String SEARCH_PARAM = "%s:*%s*,";

    @Autowired
    ICityService cityService;

    @PostMapping(value = "/saveVilles")
    public ResponseEntity<List<CityDto>> saveCities(@RequestBody List<CityDto> cities) {
        return ResponseEntity.ok(cityService.createCities(cities));
    }

    @PutMapping(value = "/updateVilles")
    public ResponseEntity<List<CityDto>> updateCities(@RequestBody List<CityDto> cities) throws NotFoundException {
        return ResponseEntity.ok(cityService.updateCities(cities));
    }

    @DeleteMapping(value = "/deleteVilles")
    public ResponseEntity<List<Long> > deleteCities(@RequestBody List<Long> cities) {
        return ResponseEntity.ok(cityService.deleteCities(cities));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<CityDto>> getAll(@RequestParam(name="page", required = false, defaultValue = "0") int page,
                                         @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(cityService.getAll(pageable));
    }

    @GetMapping(value = "/getVilleById")
    public ResponseEntity<CityDto> getById(@RequestParam(name="id") Long id) throws NotFoundException {
        return ResponseEntity.ok(cityService.getById(id));
    }

    @GetMapping(value = "/getVillesByCountry")
    public ResponseEntity<List<CityDto>> getCitiesByCountry(@RequestParam(name="countryId") Long countryId) {
        return ResponseEntity.ok(cityService.findByContry(countryId));
    }

    @GetMapping(value = "/getVillesByPgeo")
    public ResponseEntity<CityDto> getCitiesByPgeo(@RequestParam(name = "pgeoId") Long pgeoId) throws NotFoundException {
        return ResponseEntity.ok(cityService.findByPgeo(pgeoId));
    }

    @GetMapping(value = "/searchVillesByName")
    public ResponseEntity<Page<CityDto >> searchCitiesByName( @RequestParam(name="name") String cityName,
                                                      @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                      @RequestParam(name="size", required = false, defaultValue = "50") int size
                                                      ) {

        String searchToken = String.format(SEARCH_PARAM, "name", cityName);
        return ResponseEntity.ok(findByCriterais(searchToken, page, size));
    }


    private Page<CityDto> findByCriterais(String searchToken, int page, int size) {
        final Pageable pageRequest = PageRequest.of(page, size);

        final List<SearchCriteria> criterias = SearchCriteriaUtils.build(searchToken);
        return cityService.findByCriteria(criterias, pageRequest);
    }
}
