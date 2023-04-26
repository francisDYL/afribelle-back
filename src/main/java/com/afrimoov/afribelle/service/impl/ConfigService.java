package com.afrimoov.afribelle.service.impl;

import com.afrimoov.afribelle.domain.Config;
import com.afrimoov.afribelle.dto.ConfigDto;
import com.afrimoov.afribelle.mapper.ConfigMapper;
import com.afrimoov.afribelle.repository.ConfigRepository;
import com.afrimoov.afribelle.service.IConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigService extends AbstractService implements IConfigService {

    private final ConfigRepository configRepository;
    private final ConfigMapper configMapper;

    public ConfigService(@Autowired ConfigRepository repository,
                         @Autowired ConfigMapper mapper) {
        this.configMapper = mapper;
        this.configRepository = repository;
    }
    @Override
    public List<ConfigDto> getConfig() {
        List<Config> configs = configRepository.findAll();
        return configMapper.toDto(configs);
    }
}
