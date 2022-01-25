package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.BookManager;

import java.util.List;

public interface IBookManagerService {
    List<BookManager> findAll();
    BookManager findById(Long id );
    void save(BookManager bookManager);
}
