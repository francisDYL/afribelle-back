package com.afrimoov.afribelle.service;

import com.afrimoov.afribelle.dto.ProductDto;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    Page<ProductDto> getAll(Pageable pageable);

    ProductDto getById(Long id) throws NotFoundException;

    Page<ProductDto> getByUserId(Long userId, Pageable pageable);

    Page<ProductDto> getByName(String name, Pageable pageable);

    Page<ProductDto> getByContryId(Long countryId, Pageable pageable);

    Page<ProductDto> getByCityId(Long cityId, Pageable pageable);

    Page<ProductDto> getByDistrictId(Long districtId, Pageable pageable);

    Page<ProductDto> getByAdresseId(Long addressId, Pageable pageable);

    Page<ProductDto> getByPrestationId(Long prestationId, Pageable pageable);

    Page<ProductDto> getByPageId(Long pageId, Pageable pageable);

    List<ProductDto> saveProducts(List<ProductDto> products);

    List<ProductDto> updateProducts(List<ProductDto> products)  throws NotFoundException;

    List<Long> deleteProducts(List<Long> pageIds);
}
