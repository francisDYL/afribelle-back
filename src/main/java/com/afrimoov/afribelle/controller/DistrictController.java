package com.afrimoov.afribelle.controller;

import com.afrimoov.afribelle.dto.CityDto;
import com.afrimoov.afribelle.dto.DistrictDto;
import com.afrimoov.afribelle.dto.SearchCriteria;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.service.IDistrictService;
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
@RequestMapping(value = "/quartiers")
@Slf4j
public class DistrictController {
    
    static String SEARCH_PARAM = "%s:*%s*,";
    
    @Autowired
    IDistrictService districtService;

    @PostMapping(value = "/saveQuartiers")
    public ResponseEntity<List<DistrictDto>> saveDistrict(@RequestBody List<DistrictDto> districts) {
        return ResponseEntity.ok(districtService.createDistricts(districts));
    }

    @PutMapping(value = "/updateQuartiers")
    public ResponseEntity<List<DistrictDto>> updateDistrict(@RequestBody List<DistrictDto> districts) throws NotFoundException {
        return ResponseEntity.ok(districtService.updateDistricts(districts));
    }

    @DeleteMapping(value = "/deleteQuartiers")
    public ResponseEntity<List<Long>> deleteDistrict(@RequestBody List<Long> districtIds) {
        return ResponseEntity.ok(districtService.deleteDistricts(districtIds));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<DistrictDto>> getAll(@RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                    @RequestParam(name="size", required = false, defaultValue = "50") int size
    ) {
        final Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(districtService.getAll(pageable));
    }

    @GetMapping(value = "/getQuartierById")
    public ResponseEntity<DistrictDto> getById(Long id) throws NotFoundException {
        return ResponseEntity.ok(districtService.findById(id));
    }

    @GetMapping(value = "/searchQuartiersByName")
    public ResponseEntity<Page<DistrictDto>> searchDistrictsByName(@RequestParam(name = "name") String name,
                                                             @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                             @RequestParam(name="size", required = false, defaultValue = "50") int size
    ) {
        String searchToken = String.format(SEARCH_PARAM, "name", name);
        return ResponseEntity.ok(findByCriterais(searchToken,page,size));
    }

    @GetMapping(value = "/searchQuartiersByPgeo")
    public ResponseEntity<DistrictDto> searchDistrictsByPgeo(@RequestParam(name = "pgeoId") Long pgeoId) throws NotFoundException {
        return ResponseEntity.ok(districtService.findByLocationId(pgeoId));
    }

    private Page<DistrictDto> findByCriterais(String searchToken, int page, int size) {
        final Pageable pageRequest = PageRequest.of(page, size);

        final List<SearchCriteria> criterias = SearchCriteriaUtils.build(searchToken);
        return districtService.findByCriteria(criterias, pageRequest);
    }

}
