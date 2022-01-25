package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Code;


public interface ICodeService {
    void save(Code code);
    void delete (Code code);
    Code findByCode(Long code);
}
