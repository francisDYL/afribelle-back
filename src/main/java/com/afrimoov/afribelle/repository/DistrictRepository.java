package com.afrimoov.afribelle.repository;

import com.afrimoov.afribelle.domain.District;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface DistrictRepository extends JpaRepository<District, Long>, JpaSpecificationExecutor<District> {

    Page<District> findAll(Specification<District> specification, Pageable pageable);

    List<District> findByCityId(Long cityId);

    List<District> findByPaysId(Long countryId);

    Optional<District> findByGeographicLocation (Long pgeoId);

}
