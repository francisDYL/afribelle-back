package com.afrimoov.afribelle.repository;

import com.afrimoov.afribelle.domain.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long>, JpaSpecificationExecutor<City> {

    Page<City> findAll(Specification<City> specification, Pageable pageable);

    List<City> findByPaysId(Long paysId);

    Optional<City> findByPgeoId(Long pgeoId);
}
