package com.afrimoov.afribelle.repository;

import com.afrimoov.afribelle.domain.Config;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConfigRepository extends JpaRepository<Config,Long>, JpaSpecificationExecutor<Config> {

    Page<Config> findAll(Specification<Config> specification, Pageable pageable);
}