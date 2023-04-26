package com.afrimoov.afribelle.controller;

import com.afrimoov.afribelle.dto.InspirationDto;
import com.afrimoov.afribelle.dto.SearchCriteria;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.service.impl.InspirationService;
import com.afrimoov.afribelle.utils.SearchCriteriaUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/inspirations")
@Slf4j
public class InspirationController {

    static String SEARCH_PARAM = "%s:*%s*,";

    @Autowired
    InspirationService inspirationService;

    @PostMapping(value = "/saveInspirations")
    public ResponseEntity<List<InspirationDto>> saveCategories(@RequestBody List<InspirationDto> inspirations) {
        return ResponseEntity.ok(inspirationService.savesInspirations(inspirations));
    }

    @PutMapping(value = "/updateInspirations")
    public ResponseEntity<List<InspirationDto>> updateCategories(@RequestBody List<InspirationDto> inspirations) throws NotFoundException {
        return ResponseEntity.ok(inspirationService.updatesInspirations(inspirations));
    }

    @DeleteMapping(value = "/deleteInspirations")
    public ResponseEntity<List<Long>> deleteCategories(@RequestBody List<Long> inspirationIds) {
        return ResponseEntity.ok(inspirationService.deleteInspirations(inspirationIds));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<Object> getAll(
            @RequestParam(name="page", required = false, defaultValue = "0") int page,
            @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(inspirationService.getAll(pageRequest));
    }

    @GetMapping(value = "/getInspirationsById")
    public ResponseEntity<Object> getById(@RequestParam(name = "id") Long id) throws NotFoundException {

        return ResponseEntity.ok(inspirationService.findById(id));
    }

    @GetMapping(value = "/searchInspirationsByName")
    public ResponseEntity<Object> searchInspirationsByName(@RequestParam(name = "name") String name,
                                                           @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                           @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        String searchToken = String.format(SEARCH_PARAM, "titre", name);
        final List<SearchCriteria> criterias = SearchCriteriaUtils.build(searchToken);
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(inspirationService.findByCriteria(criterias,pageRequest));
    }

}
