package com.maids.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maids.library.entity.BorrowingRecord;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {
}