package com.afrimoov.afribelle.service;

import com.afrimoov.afribelle.dto.SearchCriteria;
import com.afrimoov.afribelle.dto.UserDto;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {

    List<UserDto> savesUsers(List<UserDto> users);

    List<UserDto> updatesUsers(List<UserDto> users) throws NotFoundException;

    List<Long> deleteUsers(List<Long> userIds);

    Page<UserDto> getAll(Pageable pageable);

    UserDto findByUserId(Long id) throws NotFoundException;

    Page<UserDto> findByCriteria(List<SearchCriteria> criterias, Pageable pageable);

    UserDto findByUserUniqueName(String userUniqueName) ;
}
