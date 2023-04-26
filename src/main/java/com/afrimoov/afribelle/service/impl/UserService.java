package com.afrimoov.afribelle.service.impl;

import com.afrimoov.afribelle.domain.Users;
import com.afrimoov.afribelle.dto.SearchCriteria;
import com.afrimoov.afribelle.dto.UserDto;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.mapper.UserMapper;
import com.afrimoov.afribelle.repository.UserRepository;
import com.afrimoov.afribelle.repository.specifications.UserSpecification;
import com.afrimoov.afribelle.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService extends AbstractService implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(@Autowired UserRepository repository,
                       @Autowired UserMapper mapper) {
        this.userRepository = repository;
        this.userMapper = mapper;
    }

    @Override
    public List<UserDto> savesUsers(List<UserDto> users) {

        List<Users> toCreate = new ArrayList<>();
        for(UserDto userDto: users) {
            Users user = userMapper.toEntity(userDto);
            toCreate.add(user);
        }

        List<Users> created = userRepository.saveAll(toCreate);
        return userMapper.toDto(created);
    }

    @Override
    public List<UserDto> updatesUsers(List<UserDto> users) throws NotFoundException {
        List<Users> toUpdate = new ArrayList<>();
        for(UserDto userDto: users) {
            Optional<Users> userOptional = userRepository.findById(userDto.getId());
            if(!userOptional.isPresent())
                throw new NotFoundException(String.format("User with id %d not found",userDto.getId()));

            Users user = userMapper.updateEntity(userOptional.get(),userDto);
            toUpdate.add(user);
        }

        List<Users> updated = userRepository.saveAll(toUpdate);
        return userMapper.toDto(updated);
    }

    @Override
    public List<Long> deleteUsers(List<Long> userIds) {
        userRepository.deleteAllById(userIds);
        return userIds;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        Page<Users> page = userRepository.findAll(pageable);
        return page.map(userMapper::toDto);
    }

    @Override
    public UserDto findByUserId(Long id) throws NotFoundException {
        Optional<Users> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent())
            throw new NotFoundException(String.format("User with id %d not found",id));

        return userMapper.toDto(userOptional.get());
    }

    @Override
    public Page<UserDto> findByCriteria(List<SearchCriteria> criterias, Pageable pageable) {
        Page<Users> page = userRepository.findAll(new UserSpecification(toSpecifications(criterias)),pageable);
        return page.map(userMapper::toDto);
    }

    @Override
    public UserDto findByUserUniqueName(String userUniqueName) {
        Optional<Users> usersOptional = userRepository.findByUsername(userUniqueName);
        if(!usersOptional.isPresent()) {
            Users user = new Users();
            user.setUsername(userUniqueName);
            return userMapper.toDto(userRepository.save(user));
        } else {
            return userMapper.toDto(usersOptional.get());
        }
    }
}
