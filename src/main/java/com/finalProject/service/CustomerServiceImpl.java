package com.finalProject.service;


import com.finalProject.entity.Customer;
import com.finalProject.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;


    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> showAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Customer with given ID" + id + "has not been found"));
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer oldCustomerData = customerRepository.findById(customer.getCustomerId()).orElseThrow(()->
                new EntityNotFoundException("Given Customer ID has not been found"));
                return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
            if(!customerRepository.existsById(id)) throw new EntityNotFoundException("Customer with ID" + id
                    + "has not been found"); //if exception thrown it goes to the next line
            customerRepository.deleteById(id);
        }
    }



