package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Customer;
import vn.codegym.repository.CustomerRepository;
import vn.codegym.service.CustomerService;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
            private CustomerRepository customerService;



    @Override
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @Override
    public List<Customer> findOne(int id) {
        return customerService.findOne(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(int id) {

    }


}
