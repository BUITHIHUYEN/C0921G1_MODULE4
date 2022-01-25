package com.example.ung_dung_muon_sach.controller;
import com.example.ung_dung_muon_sach.model.BookManager;
import com.example.ung_dung_muon_sach.service.IBookManagerService;
import com.example.ung_dung_muon_sach.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookManagerController {
    @Autowired
    private IBookManagerService iBookManagerService;
    @Autowired
    private ICodeService iCodeService;
    @GetMapping("/book")
    public ModelAndView showList() {
        return new ModelAndView("list", "bookManagerList", iBookManagerService.findAll());
    }

    @GetMapping("/create/{id}")
    public ModelAndView showCreateForm(@PathVariable Long id) {
        return new ModelAndView("show", "book", iBookManagerService.findById(id));
    }
    @GetMapping("/borrow/{id}")
    public String borrow(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        BookManager bookManager = iBookManagerService.findById(id);
        if (bookManager.getTheRemainingAmount()!= 0) {
            bookManager.setTheRemainingAmount(bookManager.getTheRemainingAmount() - 1);
            iBookManagerService.save(bookManager);
            redirectAttributes.addFlashAttribute("mess", "Ok mượn thành công");
            return "redirect:/book";
        }else {
            return "erro-404";
        }
    }
    @GetMapping("/pay/{id}")
    public String payBook(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        BookManager bookManager = iBookManagerService.findById(id);
        if (bookManager == null) {
            return "error-404";
        }
        bookManager.setTheRemainingAmount(bookManager.getTheRemainingAmount() + 1);
        iBookManagerService.save(bookManager);
        redirectAttributes.addFlashAttribute("mess", "Ok trả thành công");
        return "redirect:/book";
    }




}
