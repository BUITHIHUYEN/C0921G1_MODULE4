package com.example.ung_dung_muon_sach.controller;

import com.example.ung_dung_muon_sach.model.BookManager;
import com.example.ung_dung_muon_sach.service.IBookManagerService;
import com.example.ung_dung_muon_sach.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookManagerController {
    @Autowired
    private IBookManagerService iBookManagerService;
    @Autowired
    private ICodeService iCodeService;
    @GetMapping("/book")
    public ModelAndView showList() {
        return new ModelAndView("book","bookList",new BookManager())
    }




}
