package com.afrimoov.afribelle.service.impl;

import com.afrimoov.afribelle.domain.PageEntity;
import com.afrimoov.afribelle.dto.PageDto;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.mapper.PageMapper;
import com.afrimoov.afribelle.repository.PageRepository;
import com.afrimoov.afribelle.service.IPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PageService extends AbstractService implements IPageService {

    private final PageRepository pageRepository;
    private final PageMapper pageMapper;

    public PageService(@Autowired PageRepository repository,
                       @Autowired PageMapper mapper) {
        this.pageMapper = mapper;
        this.pageRepository = repository;
    }


    @Override
    public Page<PageDto> getAll(Pageable pageable) {
        Page<PageEntity> page = pageRepository.findAll(pageable);
        return page.map(pageMapper::toDto);
    }

    @Override
    public PageDto getById(Long id) throws NotFoundException {
        Optional<PageEntity> optionalPageEntity = pageRepository.findById(id);
        if(!optionalPageEntity.isPresent())
            throw new NotFoundException(String.format("Page with id %d not found",id));

        return pageMapper.toDto(optionalPageEntity.get());
    }

    @Override
    public List<PageDto> getByUserId(Long userId) {
       List<PageEntity> pages = pageRepository.findByUser(userId);
       return  pageMapper.toDto(pages);
    }

    @Override
    public Page<PageDto> getByName(String name, Pageable pageable) {
        Page<PageEntity> page = pageRepository.findByName(name,pageable);
        return page.map(pageMapper::toDto);
    }

    @Override
    public Page<PageDto> getByContryId(Long countryId, Pageable pageable) {
        Page<PageEntity> page = pageRepository.findByCountryId(countryId,pageable);
        return page.map(pageMapper::toDto);
    }

    @Override
    public Page<PageDto> getByCityId(Long cityId, Pageable pageable) {
        Page<PageEntity> page = pageRepository.findByCityId(cityId,pageable);
        return page.map(pageMapper::toDto);
    }

    @Override
    public Page<PageDto> getByDistrictId(Long districtId, Pageable pageable) {
        Page<PageEntity> page = pageRepository.findByDistrictId(districtId,pageable);
        return page.map(pageMapper::toDto);
    }

    @Override
    public PageDto getByAdresseId(Long adresseId) throws NotFoundException {
        Optional<PageEntity> optionalPageEntity = pageRepository.findByAddressId(adresseId);
        if(!optionalPageEntity.isPresent())
            throw new NotFoundException(String.format("No page found for address with id %d",adresseId));

        return pageMapper.toDto(optionalPageEntity.get());
    }

    @Override
    public List<PageDto> savePages(List<PageDto> pages) {
        List<PageEntity> toSave = new ArrayList<>();
        for(PageDto page : pages) {
            toSave.add(pageMapper.toEntity(page));
        }

        List<PageEntity> saved = pageRepository.saveAll(toSave);
        return pageMapper.toDto(saved);
    }

    @Override
    public List<PageDto> updatePages(List<PageDto> pages) throws NotFoundException {
        List<PageEntity> toSave = new ArrayList<>();
        for(PageDto page : pages) {
            Optional<PageEntity> optionalPageEntity = pageRepository.findById(page.getId());
            if(!optionalPageEntity.isPresent()) throw new NotFoundException(String.format("Page with id %d not found",page.getId()));
            toSave.add(pageMapper.toEntity(page));
        }

        List<PageEntity> updated = pageRepository.saveAll(toSave);
        return pageMapper.toDto(updated);
    }

    @Override
    public List<Long> deletePages(List<Long> pageIds) {
        pageRepository.deleteAllById(pageIds);
        return pageIds;
    }
}
