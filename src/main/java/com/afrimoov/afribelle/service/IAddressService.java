package com.afrimoov.afribelle.service;

import com.afrimoov.afribelle.dto.AddressDto;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAddressService {

    List<AddressDto> savesAddresses(List<AddressDto> addresses);

    List<AddressDto> updatesAddresses(List<AddressDto> addresses) throws NotFoundException;

    List<Long> deleteAddresses(List<Long> addressIds);

    Page<AddressDto> getAll(Pageable pageable);

    AddressDto findByAddressId(Long id) throws NotFoundException;

    AddressDto findByUserId(Long userId) throws NotFoundException;




}
