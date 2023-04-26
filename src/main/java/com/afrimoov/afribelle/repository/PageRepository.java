package com.afrimoov.afribelle.repository;

import com.afrimoov.afribelle.domain.PageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PageRepository extends JpaRepository<PageEntity, Long>, JpaSpecificationExecutor<PageEntity> {

    Page<PageEntity> findAll(Specification<PageEntity> specification, Pageable pageable);

    @Query(value = "select p from PageEntity p where p.country.id = :id")
    Page<PageEntity> findByCountryId(@Param("id") Long countryId, Pageable pageable);

    @Query(value = "select p from PageEntity p where p.ville.id = :id")
    Page<PageEntity> findByCityId(@Param("id") Long cityId, Pageable pageable);

    @Query(value = "select p from PageEntity p where p.quartier.id = :id")
    Page<PageEntity> findByDistrictId(@Param("id") Long districtId, Pageable pageable);

    @Query(value = "select p from PageEntity p where p.adresse.id = :id")
    Optional<PageEntity> findByAddressId(@Param("id") Long addressId);

    Page<PageEntity>  findByName(String name, Pageable pageable);

    List<PageEntity> findByUser(Long userId);
}
