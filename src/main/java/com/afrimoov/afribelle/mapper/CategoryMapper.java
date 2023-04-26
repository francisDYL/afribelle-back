package com.afrimoov.afribelle.mapper;

import com.afrimoov.afribelle.domain.Category;
import com.afrimoov.afribelle.dto.CategoryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends AbstractMapper<Category, CategoryDto> {
}
