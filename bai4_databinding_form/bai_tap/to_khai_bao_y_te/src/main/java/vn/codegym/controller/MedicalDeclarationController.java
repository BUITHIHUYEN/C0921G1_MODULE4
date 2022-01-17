package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.codegym.model.MedicalDeclaration;
import vn.codegym.service.IMedicalDeclarationService;

import java.util.List;

@Controller
public class MedicalDeclarationController {
    IMedicalDeclarationService iMedicalDeclarationService;
    @GetMapping("/list")
    public String findAll(Model model){
        List<MedicalDeclaration> medicalDeclaratons = iMedicalDeclarationService.findAll();
        model.addAttribute("medicalDeclaratons",medicalDeclaratons);
        return "list";
    }

    @PostMapping("/list")
    public String createNew(@ModelAttribute MedicalDeclaration medicalDeclaration){
        iMedicalDeclarationService.createNew(medicalDeclaration);
        return "redirect:/list";
    }
}
