package com.afrimoov.afribelle.repository;

import com.afrimoov.afribelle.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository  extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    Page<Product> findAll(Specification<Product> specification, Pageable pageable);

    @Query(value = "select p from Product p where p.country = :id")
    Page<Product> findByCountryId(@Param("id") Long countryId, Pageable pageable);

    @Query(value = "select p from Product p where p.ville = :id")
    Page<Product> findByCityId(@Param("id") Long cityId, Pageable pageable);

    @Query(value = "select p from Product p where p.quartier = :id")
    Page<Product> findByDistrictId(@Param("id") Long districtId, Pageable pageable);


    @Query(value = "select p from Product p where p.adresse = :id")
    Page<Product> findByAddressId(@Param("id") Long addressId, Pageable pageable);

    @Query(value = "select p from Product p where p.page = :id")
    Page<Product> findByPageId(@Param("id") Long pageId, Pageable pageable);

    Page<Product>  findByName(String name, Pageable pageable);

    Page<Product> findByUser(Long userId, Pageable pageable);

    Page<Product> findByPrestionId(Long prestationId, Pageable pageable);
}
