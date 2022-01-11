package vn.codegym.service;

import vn.codegym.model.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> findAll();

    public List<Customer> findOne(int id);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(int id);

}
