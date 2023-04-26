package com.afrimoov.afribelle.controller;

import com.afrimoov.afribelle.dto.PrestationDto;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.service.IPrestationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/prestations")
@Slf4j
public class PrestationController {

    @Autowired
    IPrestationService prestationService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Object> getAll(
            @RequestParam(name="page", required = false, defaultValue = "0") int page,
            @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(prestationService.getAll(pageRequest));
    }


    @GetMapping(value = "/getPrestationById")
    public ResponseEntity<PrestationDto> getById(@RequestParam(name = "id") Long id) throws NotFoundException {
        return ResponseEntity.ok(prestationService.getById(id));
    }

    @GetMapping(value = "/getPrestationsByPage")
    public ResponseEntity<Page<PrestationDto>> getPrestationsByPage(@RequestParam(name = "pageId") Long pageId,
                                                       @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                       @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(prestationService.getByPageId(pageId, pageRequest));
    }

    @GetMapping(value = "/getPrestationsByUser")
    public ResponseEntity<Page<PrestationDto>> getPrestationsByUser(@RequestParam(name = "userId") Long userId,
                                                       @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                       @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(prestationService.getByUserId(userId, pageRequest));
    }

    @GetMapping(value = "/getPrestationsByCountry")
    public ResponseEntity<Page<PrestationDto>> getPrestationsByCountry(@RequestParam(name = "countryId") Long countryId,
                                                          @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                          @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(prestationService.getByContryId(countryId, pageRequest));
    }

    @GetMapping(value = "/getPrestationsByVille")
    public ResponseEntity<Page<PrestationDto>> getPrestationsByCity(@RequestParam(name = "cityId") Long cityId,
                                                       @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                       @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(prestationService.getByCityId(cityId, pageRequest));
    }

    @GetMapping(value = "/getPrestationsByQuartier")
    public ResponseEntity<Page<PrestationDto>> getPrestationsByDistrict(@RequestParam(name = "districtId") Long districtId,
                                                           @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                           @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(prestationService.getByDistrictId(districtId, pageRequest));
    }

    @GetMapping(value = "/getPrestationsByPgeo")
    public ResponseEntity<Page<PrestationDto>> getPrestationsByPgeo(Object pgeo) {
        //TODO
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/searchPrestationsByName")
    public ResponseEntity<Page<PrestationDto>> searchPrestationsByName(@RequestParam(name = "name") String name,
                                                          @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                          @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(prestationService.getByName(name, pageRequest));
    }

    @PostMapping(value = "/savePresatations")
    public ResponseEntity<List<PrestationDto>> savePrestations(@RequestBody List<PrestationDto> prestations) {
        return ResponseEntity.ok(prestationService.savePrestations(prestations));
    }

    @PutMapping(value = "/updatePrestations")
    public ResponseEntity<List<PrestationDto>> updatePrestations(@RequestBody List<PrestationDto> prestations) throws NotFoundException {
        return ResponseEntity.ok(prestationService.updatePrestations(prestations));
    }

    @DeleteMapping(value = "/deletePrestations")
    public ResponseEntity<List<Long>> deletePrestations(@RequestBody List<Long> prestations) {
        return ResponseEntity.ok(prestationService.deletePrestations(prestations));
    }


}
