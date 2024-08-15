package com.maids.library.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.maids.library.entity.BorrowingRecord;
import com.maids.library.repository.BorrowingRecordRepository;

import jakarta.transaction.Transactional;

@Service
public class BorrowingRecordService {
    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    @Transactional
    public BorrowingRecord saveBorrowingRecord(BorrowingRecord record) {
        return borrowingRecordRepository.save(record);
    }

    @Cacheable(value = "borrowingRecord", key = "#id")
    public Optional<BorrowingRecord> getBorrowingRecordById(Long id) {
        return borrowingRecordRepository.findById(id);
    }

    @Transactional
    public void deleteBorrowingRecord(Long id) {
        borrowingRecordRepository.deleteById(id);
    }
}
