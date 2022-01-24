package com.example.ung_dung_muon_sach.repository;

import com.example.ung_dung_muon_sach.model.BookManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBookManagerRepository extends JpaRepository<BookManager,Long>{
}
