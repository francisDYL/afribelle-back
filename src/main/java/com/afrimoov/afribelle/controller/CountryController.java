package com.afrimoov.afribelle.controller;

import com.afrimoov.afribelle.domain.Category;
import com.afrimoov.afribelle.dto.CategoryDto;
import com.afrimoov.afribelle.dto.CountryDto;
import com.afrimoov.afribelle.dto.SearchCriteria;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.service.ICountryService;
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
@RequestMapping(value = "/countries")
@Slf4j
public class CountryController {

    static String SEARCH_PARAM = "%s:*%s*,";

    @Autowired
    ICountryService countryService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<CountryDto>> getAll(@RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                   @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(countryService.getAll(pageable));
    }


    @GetMapping(value = "/getById")
    public ResponseEntity<CountryDto> getById(@RequestParam(name="id")Long id) throws NotFoundException {
        return ResponseEntity.ok(countryService.getById(id));
    }

    @GetMapping(value = "/searchByName")
    public ResponseEntity<Page<CountryDto>> searchByName( @RequestParam(name="name") String name,
                                                @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                @RequestParam(name="size", required = false, defaultValue = "50") int size
    ) {
        String searchToken = String.format(SEARCH_PARAM, "name", name);
        return ResponseEntity.ok(findByCriterais(searchToken, page, size));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<List<CountryDto>> save(@RequestBody List<CountryDto> countries) {
        return ResponseEntity.ok(countryService.createCountries(countries));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<List<CountryDto>> update(@RequestBody List<CountryDto> countries) throws NotFoundException {
        return ResponseEntity.ok(countryService.updateCountries(countries));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<List<Long>> delete(@RequestBody List<Long> ids) {
        return ResponseEntity.ok(countryService.deleteCountries(ids));
    }

    private Page<CountryDto> findByCriterais(String searchToken, int page, int size) {
        final Pageable pageRequest = PageRequest.of(page, size);

        final List<SearchCriteria> criterias = SearchCriteriaUtils.build(searchToken);
        return countryService.findByCriteria(criterias, pageRequest);
    }


}
