package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Code;

import java.util.Optional;

public interface ICodeService {
    void create(Code code);
    void delete (Code code);
    Code findByCode(Long code);
}
