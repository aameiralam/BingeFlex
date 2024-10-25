package com.finalProject.service;


import com.finalProject.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    List<Customer> showAllCustomer();

    Customer getById(Long id);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Long id);


}
