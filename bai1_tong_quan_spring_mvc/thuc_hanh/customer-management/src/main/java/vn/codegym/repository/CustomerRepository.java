package vn.codegym.repository;

import vn.codegym.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    List<Customer> findById();

}
