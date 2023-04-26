package com.afrimoov.afribelle.service.impl;

import com.afrimoov.afribelle.domain.Category;
import com.afrimoov.afribelle.dto.CategoryDto;
import com.afrimoov.afribelle.dto.SearchCriteria;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.mapper.CategoryMapper;
import com.afrimoov.afribelle.repository.CategoryRepository;
import com.afrimoov.afribelle.repository.specifications.CategorySpecification;
import com.afrimoov.afribelle.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService extends AbstractService implements ICategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper mapper;

    public CategoryService(@Autowired CategoryRepository categoryRepository,
                           @Autowired CategoryMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public List<CategoryDto> createCategories(List<CategoryDto> categories) {
        List<Category> toCreate = mapper.toEntity(categories);
        List<Category> saved = categoryRepository.saveAll(toCreate);

        return mapper.toDto(saved);
    }

    @Override
    public List<CategoryDto> updateCategories(List<CategoryDto> categories) throws NotFoundException {
        List<Category> toUpdate = new ArrayList<>();
            for(CategoryDto categoryDto: categories) {
                Optional<Category> categoryOptional = categoryRepository.findById(categoryDto.getId());
                if(!categoryOptional.isPresent())
                    throw new NotFoundException(String.format("Category with id %d not found",categoryDto.getId()));
                Category category = categoryOptional.get();
                mapper.updateEntity(category, categoryDto);
                toUpdate.add(category);
            }

        List<Category> updated = categoryRepository.saveAll(toUpdate);
        return mapper.toDto(updated);
    }

    @Override
    public List<Long> deleteCategories(List<Long> categories) {
        categoryRepository.deleteAllById(categories);
        return categories;
    }

    @Override
    public Page<CategoryDto> getAll(Pageable pageable) {
        final Page<Category> page = categoryRepository.findAll(pageable);
        return page.map(mapper::toDto);
    }

    @Override
    public CategoryDto getById(Long id) throws NotFoundException {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(!categoryOptional.isPresent())
            throw new NotFoundException(String.format("Category with id %d not found",id));

        return mapper.toDto(categoryOptional.get());
    }


    @Override
    public Page<CategoryDto> findByCriteria(List<SearchCriteria> criterias, Pageable pageable) {
        final Page<Category> page = categoryRepository.findAll(new CategorySpecification(toSpecifications(criterias)), pageable);
        return page.map(mapper::toDto);
    }
}
