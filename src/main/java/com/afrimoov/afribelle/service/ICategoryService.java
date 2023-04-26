package com.afrimoov.afribelle.service;

import com.afrimoov.afribelle.dto.CategoryDto;
import com.afrimoov.afribelle.dto.SearchCriteria;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {

    List<CategoryDto> createCategories(List<CategoryDto> categories);

    List<CategoryDto> updateCategories(List<CategoryDto> categories) throws NotFoundException;

    List<Long> deleteCategories(List<Long> categories);

    Page<CategoryDto> getAll(Pageable pageable);

    CategoryDto getById(Long id) throws NotFoundException;

    Page<CategoryDto> findByCriteria(List<SearchCriteria> criterias, Pageable pageable);
}
