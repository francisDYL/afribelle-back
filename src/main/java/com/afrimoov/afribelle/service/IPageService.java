package com.afrimoov.afribelle.service;

import com.afrimoov.afribelle.dto.PageDto;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPageService {

    Page<PageDto> getAll(Pageable pageable);

    PageDto getById(Long id) throws NotFoundException;

    List<PageDto> getByUserId(Long userId);

    Page<PageDto> getByName(String name, Pageable pageable);

    Page<PageDto> getByContryId(Long countryId, Pageable pageable);

    Page<PageDto> getByCityId(Long cityId, Pageable pageable);

    Page<PageDto> getByDistrictId(Long districtId, Pageable pageable);

    PageDto getByAdresseId(Long adresseId) throws NotFoundException;

    List<PageDto> savePages(List<PageDto> pages);

    List<PageDto> updatePages(List<PageDto> pages)  throws NotFoundException;

    List<Long> deletePages(List<Long> pageIds);

}
