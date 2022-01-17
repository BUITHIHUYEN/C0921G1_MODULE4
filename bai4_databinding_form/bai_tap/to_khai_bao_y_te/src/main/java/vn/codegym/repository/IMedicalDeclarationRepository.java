package vn.codegym.repository;

import vn.codegym.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalDeclarationRepository {
    public List<MedicalDeclaration> findAll();
    public void createNew(MedicalDeclaration medicalDeclaration);
}
