package com.afrimoov.afribelle.repository;

import com.afrimoov.afribelle.domain.Prestation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PrestationRepository extends JpaRepository<Prestation, Long>, JpaSpecificationExecutor<Prestation> {

    Page<Prestation> findAll(Specification<Prestation> specification, Pageable pageable);

    @Query(value = "select p from Prestation p where p.country = :id")
    Page<Prestation> findByCountryId(@Param("id") Long countryId, Pageable pageable);

    @Query(value = "select p from Prestation p where p.ville = :id")
    Page<Prestation> findByCityId(@Param("id") Long cityId, Pageable pageable);

    @Query(value = "select p from Prestation p where p.quartier = :id")
    Page<Prestation> findByDistrictId(@Param("id") Long districtId, Pageable pageable);

    @Query(value = "select p from Prestation p where p.adresse = :id")
    Page<Prestation> findByAddressId(@Param("id") Long addressId, Pageable pageable);

   @Query(value = "select p from Prestation p where p.page = :id")
    Page<Prestation> findByPageId(@Param("id") Long pageId, Pageable pageable);

    Page<Prestation>  findByName(String name, Pageable pageable);

    Page<Prestation> findByUser(Long userId, Pageable pageable);
}
