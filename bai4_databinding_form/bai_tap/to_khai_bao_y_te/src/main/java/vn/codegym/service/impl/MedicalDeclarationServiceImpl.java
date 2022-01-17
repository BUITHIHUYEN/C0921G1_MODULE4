package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.MedicalDeclaration;
import vn.codegym.repository.IMedicalDeclarationRepository;
import vn.codegym.service.IMedicalDeclarationService;

import java.util.List;
@Service
public class MedicalDeclarationServiceImpl implements IMedicalDeclarationService {
    @Autowired
    IMedicalDeclarationRepository iMedicalDeclarationRepository;

    @Override
    public List<MedicalDeclaration> findAll() {
        return iMedicalDeclarationRepository.findAll();
    }

    @Override
    public void createNew(MedicalDeclaration medicalDeclaration) {
        iMedicalDeclarationRepository.createNew(medicalDeclaration);

    }
}
