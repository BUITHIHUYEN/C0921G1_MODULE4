package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Customer;
import vn.codegym.service.CustomerService;
import vn.codegym.service.impl.CustomerServiceImpl;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public ModelAndView showList() {
        List<Customer> customerList = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("customerList" ,customerList);
        return modelAndView;
    }
    @PostMapping("/updateCustomer")
    public String updateCustomer(@RequestParam int cId, @RequestParam String name, @RequestParam String email, @RequestParam String address) {
        Customer customer = new Customer(cId,name,email,address);
        customerService.updateCustomer(customer);
        return "redirect:/";

    }
    @GetMapping("/ShowUpdateCustomer")
    public ModelAndView showUpdateCustomer(@RequestParam int cId) {
        List<Customer> customers = customerService.findOne(cId);
        Customer customer = new Customer();
        for (Customer cus: customers) {
            customer.setId(cus.getId());
            customer.setName(cus.getName());
            customer.setEmail(cus.getEmail());
            customer.setAddress(cus.getAddress());
        }
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("customer" ,customer);
        return modelAndView;
    }
    @GetMapping("/searchCustomer")
    public ModelAndView searchCustomer(@RequestParam int id) {
        List<Customer> customers = customerService.findOne(id);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("customerList" ,customers);
        return modelAndView;
    }

}
