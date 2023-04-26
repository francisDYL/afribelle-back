package com.afrimoov.afribelle.controller;

import com.afrimoov.afribelle.dto.PageDto;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.service.IPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pages")
@Slf4j
public class PageController {

    @Autowired
    IPageService pageService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<PageDto>> getAll(@RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                @RequestParam(name="size", required = false, defaultValue = "50") int size
    ) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(pageService.getAll(pageRequest));
    }


    @GetMapping(value = "/getPageById")
    public ResponseEntity<PageDto> getById(@RequestParam(name = "id") Long id) throws NotFoundException {
        return ResponseEntity.ok(pageService.getById(id));
    }

    @GetMapping(value = "/getPagesByUser")
    public ResponseEntity<List<PageDto>> searchByUserId(Long userId) {
        return ResponseEntity.ok(pageService.getByUserId(userId));
    }

    @GetMapping(value = "/searchPageByName")
    public ResponseEntity<Page<PageDto>> searchByName(@RequestParam(name = "name") String name,
                                                      @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                      @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(pageService.getByName(name,pageRequest));
    }

    @GetMapping(value = "/getPagesByCountry")
    public ResponseEntity<Page<PageDto>> getPagesByCounty(@RequestParam(name = "countryId") Long countryId,
                                                          @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                          @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(pageService.getByContryId(countryId,pageRequest));
    }

    @GetMapping(value = "/getPagesByVille")
    public ResponseEntity<Page<PageDto>> getPagesByCity(@RequestParam(name = "cityId") Long cityId,
                                                        @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                        @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(pageService.getByCityId(cityId,pageRequest));
    }

    @GetMapping(value = "/getPagesByQuartier")
    public ResponseEntity<Page<PageDto>> getPagesByDistrict(@RequestParam(name = "districtId") Long districtId,
                                                            @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                            @RequestParam(name="size", required = false, defaultValue = "50") int size
                                                            ) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(pageService.getByDistrictId(districtId,pageRequest));
    }

    @GetMapping(value = "/getPagesByPgeo")
    public ResponseEntity<PageDto> getPagesByPgoe(Object pgoe) {
        //TODO
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/getPagesByAdresse")
    public ResponseEntity<PageDto> getPagesByAdresse(@RequestParam(name = "addressId") Long addressId) throws NotFoundException {
        return ResponseEntity.ok(pageService.getByAdresseId(addressId));
    }

    @PostMapping(value = "/savePages")
    public ResponseEntity<List<PageDto>> save(@RequestBody List<PageDto> pages) {
        return ResponseEntity.ok(pageService.savePages(pages));
    }

    @PutMapping(value = "/updatePages")
    public ResponseEntity<List<PageDto>> update(@RequestBody List<PageDto> pages) throws NotFoundException {
        return ResponseEntity.ok(pageService.updatePages(pages));
    }

    @DeleteMapping(value = "/deletePages")
    public ResponseEntity<List<Long>> deletePages(@RequestBody List<Long> pages) {
        return ResponseEntity.ok(pageService.deletePages(pages));
    }
}
