package com.example.ung_dung_muon_sach.repository;
import com.example.ung_dung_muon_sach.model.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICodeRepository extends JpaRepository<Code,Long> {
    Code findByCode (Long Code);
}
