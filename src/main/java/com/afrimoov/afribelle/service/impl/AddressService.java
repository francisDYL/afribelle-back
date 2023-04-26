package com.afrimoov.afribelle.service.impl;

import com.afrimoov.afribelle.domain.Address;
import com.afrimoov.afribelle.dto.AddressDto;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.mapper.AddressMapper;
import com.afrimoov.afribelle.repository.AddressRepository;
import com.afrimoov.afribelle.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService extends AbstractService implements IAddressService {

    private final AddressRepository repository;
    private final AddressMapper mapper;

    public AddressService(
            @Autowired AddressRepository addressRepository,
            @Autowired AddressMapper addressMapper
            ) {
        this.repository = addressRepository;
        this.mapper = addressMapper;
    }
    @Override
    public List<AddressDto> savesAddresses(List<AddressDto> addresses) {

        List<Address> toCreate = new ArrayList<>();
        for (AddressDto addressDto: addresses) {
            Address address = mapper.toEntity(addressDto);
            toCreate.add(address);
        }

        List<Address> created = repository.saveAll(toCreate);
        return mapper.toDto(created);
    }

    @Override
    public List<AddressDto> updatesAddresses(List<AddressDto> addresses) throws NotFoundException {
        List<Address> toUpdate = new ArrayList<>();

        for (AddressDto addressDto: addresses) {
            Optional<Address> optionalAddress = repository.findById(addressDto.getId());
            if(!optionalAddress.isPresent())
                throw new NotFoundException(String.format("Address with id %d not found",addressDto.getId()));

            Address address = mapper.updateEntity(optionalAddress.get(), addressDto);
            toUpdate.add(address);
        }

        List<Address> updated = repository.saveAll(toUpdate);
        return mapper.toDto(updated);
    }

    @Override
    public List<Long> deleteAddresses(List<Long> addressIds) {
        repository.deleteAllById(addressIds);
        return addressIds;
    }

    @Override
    public Page<AddressDto> getAll(Pageable pageable) {
        Page<Address> page = repository.findAll(pageable);
        return page.map(mapper::toDto);
    }

    @Override
    public AddressDto findByAddressId(Long id) throws NotFoundException {
        Optional<Address> optionalAddress = repository.findById(id);
        if(!optionalAddress.isPresent()) throw new NotFoundException(String.format("Address with id %d not found",id));

        return mapper.toDto(optionalAddress.get());
    }

    @Override
    public AddressDto findByUserId(Long userId) throws NotFoundException {
        Optional<Address> optionalAddress = repository.findByUserId(userId);
        if(!optionalAddress.isPresent())
            throw new NotFoundException(String.format("No address found for usr with id %d",userId));

        return mapper.toDto(optionalAddress.get());
    }
}
