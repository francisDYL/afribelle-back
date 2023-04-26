package com.afrimoov.afribelle.mapper;

import com.afrimoov.afribelle.domain.Users;
import com.afrimoov.afribelle.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends AbstractMapper<Users, UserDto> {
}
