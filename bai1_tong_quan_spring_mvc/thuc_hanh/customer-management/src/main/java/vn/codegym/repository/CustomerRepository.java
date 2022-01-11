package vn.codegym.repository;

import vn.codegym.model.Customer;

import java.util.List;

public interface CustomerRepository {
    public List<Customer> findAll();

    public List<Customer> findOne(int id);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(int id);
}
