package com.example.ung_dung_muon_sach.service.impl;

import com.example.ung_dung_muon_sach.model.BookManager;
import com.example.ung_dung_muon_sach.repository.IBookManagerRepository;
import com.example.ung_dung_muon_sach.service.IBookManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookManagerServiceImpl implements IBookManagerService {
    @Autowired
    private IBookManagerRepository iBookManagerRepository;
    @Override
    public List<BookManager> findAll() {
        return iBookManagerRepository.findAll();
    }

    @Override
    public BookManager findById(Long id) {
        return iBookManagerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BookManager bookManager) {
        iBookManagerRepository.save(bookManager);
    }
}
