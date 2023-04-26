package com.afrimoov.afribelle.repository;

import com.afrimoov.afribelle.domain.Pgeo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PgeoRepository  extends JpaRepository<Pgeo, Long> {

    Page<Pgeo> findAll(Pageable pageable);
}
