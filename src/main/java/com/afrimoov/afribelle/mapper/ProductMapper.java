package com.afrimoov.afribelle.mapper;

import com.afrimoov.afribelle.domain.Product;
import com.afrimoov.afribelle.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;

@Mapper(componentModel = "spring",
        mappingInheritanceStrategy = MappingInheritanceStrategy.EXPLICIT)
public interface ProductMapper extends AbstractMapper<Product, ProductDto> {
}
