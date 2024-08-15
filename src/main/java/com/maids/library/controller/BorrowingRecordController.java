package com.maids.library.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maids.library.entity.BorrowingRecord;
import com.maids.library.service.BookService;
import com.maids.library.service.BorrowingRecordService;
import com.maids.library.service.PatronService;

@RestController
@RequestMapping("/api")
public class BorrowingRecordController {

    @Autowired
    private BorrowingRecordService borrowingRecordService;

    @Autowired
    private BookService bookService;

    @Autowired
    private PatronService patronService;

    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecord> borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        return bookService.getBookById(bookId).flatMap(book -> 
            patronService.getPatronById(patronId).map(patron -> {
                BorrowingRecord record = new BorrowingRecord();
                record.setBook(book);
                record.setPatron(patron);
                record.setBorrowDate(LocalDate.now());
                return ResponseEntity.ok(borrowingRecordService.saveBorrowingRecord(record));
            })
        ).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecord> returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        return borrowingRecordService.getBorrowingRecordById(bookId).map(record -> {
            record.setReturnDate(LocalDate.now());
            return ResponseEntity.ok(borrowingRecordService.saveBorrowingRecord(record));
        }).orElse(ResponseEntity.notFound().build());
    }
}
