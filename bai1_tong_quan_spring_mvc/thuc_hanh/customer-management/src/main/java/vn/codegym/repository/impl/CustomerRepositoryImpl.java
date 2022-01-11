package vn.codegym.repository.impl;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Customer;
import vn.codegym.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private static List<Customer> customerList;

    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Nguyễn Văn Hùng", "hungnguyen@gmail.com", "Ninh Bình"));
        customerList.add(new Customer(2, "Trần Văn Công", "congtran@gmail.com", "Đà Nẵng"));
        customerList.add(new Customer(3, "Đoàn Huỳnh Ngọc Tài", "taidoan@gmail.com", "Quãng Nam"));
        customerList.add(new Customer(4, "Lê Văn Tiến", "tienle@gmail.com", "Quãng Nam"));
        customerList.add(new Customer(5, "Vũ Trọng Dương", "duongvu@gmail.com", "Đà Nẵng"));
        customerList.add(new Customer(6, "Nguyễn Khắc Từ", "tunguyen@gmail.com", "Quãng Trị"));
        customerList.add(new Customer(7, "Bùi Thị Huyền", "huyenbui@gmail.com", "Gia Lai"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public List<Customer> findOne(int id) {
        List<Customer> customers = new ArrayList<>();
        for (Customer customer : customerList) {
            if (id == customer.getId()) {
                customers.add(customer);
            }
        }
        return customers;
    }

    @Override
    public void updateCustomer(Customer customer) {
        for(int i=0;i<customerList.size();i++){
            if (customerList.get(i).getId() == customer.getId()) {
                customerList.get(i).setId(customer.getId());
                customerList.get(i).setName(customer.getName());
                customerList.get(i).setEmail(customer.getEmail());
                customerList.get(i).setAddress(customer.getAddress());
            }
        }
    }

    @Override
    public void deleteCustomer(int id) {

    }
}

