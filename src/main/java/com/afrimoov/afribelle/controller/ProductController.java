package com.afrimoov.afribelle.controller;

import com.afrimoov.afribelle.dto.ProductDto;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
@Slf4j
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<ProductDto>> getAll(
            @RequestParam(name="page", required = false, defaultValue = "0") int page,
            @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(productService.getAll(pageRequest));
    }


    @GetMapping(value = "/getProduitById")
    public ResponseEntity<ProductDto> getById(@RequestParam(name = "id") Long id) throws NotFoundException {
        return ResponseEntity.ok(productService.getById(id));
    }

    @GetMapping(value = "/getProduitsByUser")
    public ResponseEntity<Page<ProductDto>> getByUserId(@RequestParam(name = "userId") Long userId,
                                                        @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                        @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(productService.getByUserId(userId, pageRequest));
    }


    @GetMapping(value = "/getProduitsByPage")
    public ResponseEntity<Page<ProductDto>> getProductsByPage(@RequestParam(name = "pageId") Long pageId,
                                                              @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                              @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(productService.getByPageId(pageId, pageRequest));
    }


    @GetMapping(value = "/getProduitsByCountry")
    public ResponseEntity<Page<ProductDto>> getProductsByCountry(@RequestParam(name = "countryId") Long countryId,
                                                                 @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                                 @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(productService.getByContryId(countryId, pageRequest));
    }

    @GetMapping(value = "/getProduitsByVille")
    public ResponseEntity<Page<ProductDto>> getProductsByCity(@RequestParam(name = "cityId") Long cityId,
                                                              @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                              @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(productService.getByCityId(cityId, pageRequest));
    }

    @GetMapping(value = "/getProduitsByQuartier")
    public ResponseEntity<Page<ProductDto>> getProductsByDistrict(@RequestParam(name = "districtId") Long districtId,
                                                                  @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                                  @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(productService.getByDistrictId(districtId, pageRequest));
    }

    @GetMapping(value = "/getProduitsByPgeo")
    public ResponseEntity<Object> getProductsByPgeo(Object pgeo) {
        //TODO todo
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/searchProduitsByName")
    public ResponseEntity<Page<ProductDto>> searchProductsByName(@RequestParam(name = "name") String name,
                                                                 @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                                 @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(productService.getByName(name, pageRequest));
    }

    @GetMapping(value = "/getProduitsByPrestation")
    public ResponseEntity<Page<ProductDto>> getProductsByPrestation(@RequestParam(name = "prestationId") Long prestationId,
                                                                    @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                                                    @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(productService.getByPrestationId(prestationId, pageRequest));
    }

    @GetMapping(value = "/getRelatedProduits")
    public ResponseEntity<Page<ProductDto>> getRelatedProducts(Object product) {
        //TODO todo
        return ResponseEntity.noContent().build();
    }


    @PostMapping(value = "/saveProduits")
    public ResponseEntity<List<ProductDto>> saveProducts(@RequestBody List<ProductDto> products) {
        return ResponseEntity.ok(productService.saveProducts(products));
    }

    @PutMapping(value = "/updateProduits")
    public ResponseEntity<List<ProductDto>> updateProducts(@RequestBody List<ProductDto>  products) throws NotFoundException {
        return ResponseEntity.ok(productService.updateProducts(products));
    }

    @DeleteMapping(value = "/deleteProduits")
    public ResponseEntity<List<Long>> deleteProducts(@RequestBody List<Long>  products) {
        return ResponseEntity.ok(productService.deleteProducts(products));
    }

}
