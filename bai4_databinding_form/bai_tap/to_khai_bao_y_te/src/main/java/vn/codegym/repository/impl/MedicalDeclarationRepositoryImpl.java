package vn.codegym.repository.impl;

import org.springframework.stereotype.Repository;
import vn.codegym.model.MedicalDeclaration;
import vn.codegym.repository.IMedicalDeclarationRepository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MedicalDeclarationRepositoryImpl implements IMedicalDeclarationRepository {
    private static final List<MedicalDeclaration> medicalDeclaratons = new ArrayList<>();
    static {
        medicalDeclaratons.add(new MedicalDeclaration("Nguyễn Thị Thu","1993","Nữ","Việt Nam","239456789","Ô tô","C79-567876","4","2022-09-25",
        "2022-09-26","không có","Đà Nẵng","Liên Chiểu","Hòa Minh","68 Nguyễn Viết Xuân,Hòa Minh,Liên Chiểu,Đà Nẵng","0987654567","thunguyen@gmail.com",
        "không","không"));
    }

    @Override
    public List<MedicalDeclaration> findAll() {
        return medicalDeclaratons;
    }

    @Override
    public void createNew(MedicalDeclaration medicalDeclaration) {
        medicalDeclaratons.add(medicalDeclaration);

    }
}
