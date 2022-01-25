package com.example.ung_dung_muon_sach.service.impl;

import com.example.ung_dung_muon_sach.model.Code;
import com.example.ung_dung_muon_sach.repository.ICodeRepository;
import com.example.ung_dung_muon_sach.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl implements ICodeService {
    @Autowired
    private ICodeRepository iCodeRepository;

    @Override
    public void save(Code code) {
        iCodeRepository.save(code);
    }

    @Override
    public void delete(Code code) {
        iCodeRepository.delete(code);

    }

    @Override
    public Code findByCode(Long code) {
        return iCodeRepository.findByCode(code);
    }
}
