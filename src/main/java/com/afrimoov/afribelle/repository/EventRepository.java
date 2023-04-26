package com.afrimoov.afribelle.repository;

import com.afrimoov.afribelle.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
