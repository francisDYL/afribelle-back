package com.afrimoov.afribelle.repository;

import com.afrimoov.afribelle.domain.Inspiration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InspirationRepository extends JpaRepository<Inspiration,Long>, JpaSpecificationExecutor<Inspiration> {

    Page<Inspiration> findAll(Specification<Inspiration> specification, Pageable pageable);
}
