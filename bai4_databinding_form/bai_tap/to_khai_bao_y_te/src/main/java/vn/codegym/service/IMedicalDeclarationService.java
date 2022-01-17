package vn.codegym.service;

import vn.codegym.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalDeclarationService {
    public List<MedicalDeclaration> findAll();
    public void createNew(MedicalDeclaration medicalDeclaration);
}
