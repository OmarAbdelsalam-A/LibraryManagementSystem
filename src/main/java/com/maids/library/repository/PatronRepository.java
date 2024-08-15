package com.maids.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maids.library.entity.Patron;

public interface PatronRepository extends JpaRepository<Patron, Long> {
}