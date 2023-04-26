package com.afrimoov.afribelle.mapper;

import com.afrimoov.afribelle.domain.Address;
import com.afrimoov.afribelle.domain.Country;
import com.afrimoov.afribelle.dto.AddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper extends AbstractMapper<Address, AddressDto> {

    default Address fromId(Long id) {
        if(id == null) return null;

        Address address = new Address();
        address.setId(id);

        return address;
    }
}
