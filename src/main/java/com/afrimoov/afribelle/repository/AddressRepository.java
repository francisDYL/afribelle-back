package com.afrimoov.afribelle.repository;

import com.afrimoov.afribelle.domain.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AddressRepository  extends JpaRepository<Address, Long>, JpaSpecificationExecutor<Address> {

    Page<Address> findAll(Specification<Address> specification, Pageable pageable);

    @Query(value = "select a from Address a left join Users u on a.id = u.adresse where u.id = :userId")
    Optional<Address> findByUserId(@Param(value = "userId") Long userId);

}
