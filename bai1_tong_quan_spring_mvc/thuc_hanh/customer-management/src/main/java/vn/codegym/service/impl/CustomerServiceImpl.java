package vn.codegym.service.impl;

import vn.codegym.model.Customer;
import vn.codegym.repository.CustomerRepository;
import vn.codegym.repository.impl.CustomerRepositoryImpl;
import vn.codegym.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findById() {
        return customerRepository.findById();
    }
}
