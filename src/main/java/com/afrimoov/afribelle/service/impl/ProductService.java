package com.afrimoov.afribelle.service.impl;

import com.afrimoov.afribelle.domain.Product;
import com.afrimoov.afribelle.dto.ProductDto;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.mapper.ProductMapper;
import com.afrimoov.afribelle.repository.ProductRepository;
import com.afrimoov.afribelle.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService extends AbstractService implements IProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(@Autowired ProductRepository repository,
                          @Autowired ProductMapper mapper) {
        this.productRepository = repository;
        this.productMapper = mapper;
    }

    @Override
    public Page<ProductDto> getAll(Pageable pageable) {

        Page<Product> page = productRepository.findAll(pageable);
        return page.map(productMapper::toDto);
    }

    @Override
    public ProductDto getById(Long id) throws NotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(!optionalProduct.isPresent()) throw new NotFoundException(String.format("Product with id %d not found", id));
        return productMapper.toDto(optionalProduct.get());
    }

    @Override
    public Page<ProductDto> getByUserId(Long userId, Pageable pageable) {

        Page<Product> page = productRepository.findByUser(userId, pageable);
        return page.map(productMapper::toDto);
    }

    @Override
    public Page<ProductDto> getByName(String name, Pageable pageable) {

        Page<Product> page = productRepository.findByName(name, pageable);
        return page.map(productMapper::toDto);
    }

    @Override
    public Page<ProductDto> getByContryId(Long countryId, Pageable pageable) {
        Page<Product> page = productRepository.findByCountryId(countryId, pageable);
        return page.map(productMapper::toDto);
    }

    @Override
    public Page<ProductDto> getByCityId(Long cityId, Pageable pageable) {

        Page<Product> page = productRepository.findByCityId(cityId, pageable);
        return page.map(productMapper::toDto);
    }

    @Override
    public Page<ProductDto> getByDistrictId(Long districtId, Pageable pageable) {

        Page<Product> page = productRepository.findByDistrictId(districtId, pageable);
        return page.map(productMapper::toDto);
    }

    @Override
    public Page<ProductDto> getByAdresseId(Long addressId, Pageable pageable) {
        Page<Product> page = productRepository.findByAddressId(addressId, pageable);
        return page.map(productMapper::toDto);
    }

    @Override
    public Page<ProductDto> getByPrestationId(Long prestationId, Pageable pageable) {

        Page<Product> page = productRepository.findByPrestionId(prestationId, pageable);
        return page.map(productMapper::toDto);
    }

    @Override
    public List<ProductDto> saveProducts(List<ProductDto> products) {
        List<Product> toSave = new ArrayList<>();
        for(ProductDto productDto : products) {
            toSave.add(productMapper.toEntity(productDto));
        }

        List<Product> saved = productRepository.saveAll(toSave);
        return productMapper.toDto(saved);
    }

    @Override
    public List<ProductDto> updateProducts(List<ProductDto> products) throws NotFoundException {
        List<Product> toUpdate = new ArrayList<>();
        for(ProductDto productDto : products) {
            Optional<Product> optionalPrestation = productRepository.findById(productDto.getId());
            if(!optionalPrestation.isPresent()) throw new NotFoundException(String.format("Product with id %d not found", productDto.getId()));
            toUpdate.add(productMapper.updateEntity(optionalPrestation.get(), productDto));
        }

        List<Product> updated = productRepository.saveAll(toUpdate);
        return productMapper.toDto(updated);
    }

    @Override
    public List<Long> deleteProducts(List<Long> pageIds) {
        productRepository.deleteAllById(pageIds);
        return pageIds;
    }

    @Override
    public Page<ProductDto> getByPageId(Long pageId, Pageable pageable) {
        Page<Product> page = productRepository.findByPageId(pageId, pageable);
        return page.map(productMapper::toDto);
    }
}
