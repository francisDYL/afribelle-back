package com.afrimoov.afribelle.controller;

import com.afrimoov.afribelle.dto.AddressDto;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.service.impl.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adresses")
@Slf4j
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping(value = "/saveAdresses")
    public ResponseEntity<List<AddressDto>> saveAddress(@RequestBody List<AddressDto> adresses) {
        return ResponseEntity.ok(addressService.savesAddresses(adresses));
    }

    @PutMapping(value = "/updateAdresses")
    public ResponseEntity<List<AddressDto>> updateAddress(@RequestBody List<AddressDto> adresses) throws NotFoundException {
        return ResponseEntity.ok(addressService.updatesAddresses(adresses));
    }

    @DeleteMapping(value = "/deleteAdresses")
    public ResponseEntity<List<Long>> deleteAddress(@RequestBody List<Long> adresses) {
        return ResponseEntity.ok(addressService.deleteAddresses(adresses));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<AddressDto>> getAll(
            @RequestParam(name="page", required = false, defaultValue = "0") int page,
            @RequestParam(name="size", required = false, defaultValue = "50") int size) {

        final Pageable pageRequest = PageRequest.of(page, size);

        return ResponseEntity.ok(addressService.getAll(pageRequest));
    }

    @GetMapping(value = "/getAdresseById")
    public ResponseEntity<AddressDto> getById(@RequestParam(name = "id") Long id) throws NotFoundException {

        return ResponseEntity.ok(addressService.findByAddressId(id));
    }

    @GetMapping(value = "/getAdresseByUser")
    public ResponseEntity<Object> getByUserId(@RequestParam(name = "userId") Long userId) throws NotFoundException {
        return ResponseEntity.ok(addressService.findByUserId(userId));
    }

}
