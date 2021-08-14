package com.example.restapimongodb.services;

import com.example.restapimongodb.models.Customer;
import com.example.restapimongodb.models.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MongoTemplate mongoTemplate;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<Customer> getCustomers()
    {
        return customerRepository.findAll();

    }
    public List<Customer> getUserByUsername(String username, String pword)
    {
        Query query = new Query();
        System.out.println("username - " +username+"  password: "+pword);
        query.addCriteria(Criteria.where("username").is(username).and("password").is(pword)); //we can put multiple type of queries
        System.out.println("query - " + query.toString());
        List<Customer> customers= mongoTemplate.find(query, Customer.class);
        System.out.println("cust - " +customers);
        return customers;
    }
    public Customer insertIntoCustomers(Customer customer)
    {
        String encodedPassword = bCryptPasswordEncoder.encode(customer.getPassword());

        customer.setPassword(encodedPassword);

        Customer insertedCustomer = customerRepository.insert(customer);

        return insertedCustomer;

    }
    public Optional<Customer> getACustomer(String id) throws Exception
    {
        Optional<Customer> customer=customerRepository.findById(id);
        //If Customer is not available in DB, it throws an exception
        if(!customer.isPresent())
        {
            throw new Exception("Customer with id: "+id+" is not found");
        }
        return customer;
    }

    public void deleteACustomer(String id) throws Exception {
        Optional<Customer> customer=customerRepository.findById(id);
        if(!customer.isPresent())
        {
            throw new Exception("Customer with id: "+id+" is not found");
        }
        customerRepository.deleteById(id);
    }


}
