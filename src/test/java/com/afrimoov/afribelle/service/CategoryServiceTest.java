package com.afrimoov.afribelle.service;

import com.afrimoov.afribelle.domain.Category;
import com.afrimoov.afribelle.dto.CategoryDto;
import com.afrimoov.afribelle.mapper.CategoryMapper;
import com.afrimoov.afribelle.repository.CategoryRepository;
import com.afrimoov.afribelle.service.impl.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

public class CategoryServiceTest {


    ICategoryService categoryService;
    CategoryRepository categoryRepository;

    @BeforeEach
    private  void setUp() {
        categoryRepository = Mockito.mock(CategoryRepository.class);
        CategoryMapper mapper = Mappers.getMapper(CategoryMapper.class);
        categoryService = new CategoryService(categoryRepository, mapper);

        when(categoryRepository.saveAll(anyList())).thenAnswer( a -> a.getArgument(0));

    }

    @Test
    public void itshouldCreateCategory() {
        //GIVEN
        ArgumentCaptor<List<Category>> captor = ArgumentCaptor.forClass(List.class);
        List<CategoryDto> toSave = new ArrayList<>();

        CategoryDto categoryDto1 = new CategoryDto();
        CategoryDto categoryDto2 = new CategoryDto();
        categoryDto1.setName("Category 1");
        categoryDto2.setName("Category 2");
        toSave.add(categoryDto1);
        toSave.add(categoryDto2);

        //WHEN
        categoryService.createCategories(toSave);

        //THEN
        verify(categoryRepository,times(1)).saveAll(captor.capture());
        List<Category> savedCategories = captor.getValue();
        assertThat(savedCategories.size()).isEqualTo(2);
    }

    @Test
    public void itshouldUpdateCategory() {
        //GIVEN
        ArgumentCaptor<List<Category>> captor = ArgumentCaptor.forClass(List.class);
        List<CategoryDto> toUpdate = new ArrayList<>();

        CategoryDto categoryDto1 = new CategoryDto();
        categoryDto1.setId(1L);
        categoryDto1.setName("Category 1");
        categoryDto1.setIllustration("https://path_to_illustration/ill1.jpg");

        CategoryDto categoryDto2 = new CategoryDto();
        categoryDto2.setId(2L);
        categoryDto2.setName("Category 2");
        categoryDto1.setIllustration("https://path_to_illustration/ill2.jpg");

        toUpdate.add(categoryDto1);
        toUpdate.add(categoryDto2);

        //WHEN
        categoryService.createCategories(toUpdate);

        //THEN
        verify(categoryRepository,times(1)).saveAll(captor.capture());
        List<Category> savedCategories = captor.getValue();
        assertThat(savedCategories.size()).isEqualTo(2);
    }

}
