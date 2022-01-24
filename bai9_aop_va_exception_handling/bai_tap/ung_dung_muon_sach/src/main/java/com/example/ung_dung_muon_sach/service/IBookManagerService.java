package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.BookManager;

import java.util.List;
import java.util.Optional;

public interface IBookManagerService {
    List<BookManager> findAll();
    BookManager findById(Long id );
}
