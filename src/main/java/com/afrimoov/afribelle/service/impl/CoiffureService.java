package com.afrimoov.afribelle.service.impl;

import com.afrimoov.afribelle.domain.Coiffure;
import com.afrimoov.afribelle.repository.CoiffureRepository;
import com.afrimoov.afribelle.service.ICoiffureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoiffureService implements ICoiffureService {

    private CoiffureRepository repository;
    public CoiffureService(@Autowired CoiffureRepository coiffureRepository) {
        super();
        this.repository = coiffureRepository;
    }

    @Override
    public List<Coiffure> getAll() {
        return this.repository.findAll();
    }
}
