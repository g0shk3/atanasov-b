package com.atanasov.service;

import com.atanasov.exeption.ResourceNotFoundException;
import com.atanasov.model.Customer;
import com.atanasov.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }


    @Override
    public void deleteCustomer(Long id) {

    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
      Optional<Customer> customer = customerRepository.findById(id);

      if(customer.isPresent()){
          return customer.get();
      }
        throw new ResourceNotFoundException("Customer not exist id :" + id);
    }
}
