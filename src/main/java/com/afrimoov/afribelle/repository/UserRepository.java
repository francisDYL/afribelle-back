package com.afrimoov.afribelle.repository;

import com.afrimoov.afribelle.domain.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long>, JpaSpecificationExecutor<Users> {

    Page<Users> findAll(Specification<Users> specification, Pageable pageable);

    Optional<Users> findByUsername(String username);
}
