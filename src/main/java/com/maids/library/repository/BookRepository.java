package com.maids.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maids.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}