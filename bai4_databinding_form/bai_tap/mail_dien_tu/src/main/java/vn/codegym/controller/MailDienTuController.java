package vn.codegym.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.nio.cs.ext.MacArabic;
import vn.codegym.model.MailDienTu;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MailDienTuController {
    @GetMapping ("/showForm")
    public String showForm(Model model){
        model.addAttribute("mailDienTu", new MailDienTu("English", 25, false, "Thor King, Asgard"));
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        model.addAttribute("languages",languages);

        List<Integer> pageSizes = new ArrayList<>();
        pageSizes.add(5);
        pageSizes.add(10);
        pageSizes.add(15);
        pageSizes.add(25);
        pageSizes.add(50);
        pageSizes.add(100);
        model.addAttribute("pageSizes",pageSizes);
        return ("index");
    }
    @PostMapping("/showForm")
    public String update(@ModelAttribute("mailDienTu") MailDienTu mailDienTu, Model model) {
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        model.addAttribute("languages", languages);
        List<Integer> pageSizes = new ArrayList<>();
        pageSizes.add(5);
        pageSizes.add(10);
        pageSizes.add(15);
        pageSizes.add(25);
        pageSizes.add(50);
        pageSizes.add(100);
        model.addAttribute("pageSizes", pageSizes);
        model.addAttribute("mess", "Update successful");
        return "index";
    }
}
