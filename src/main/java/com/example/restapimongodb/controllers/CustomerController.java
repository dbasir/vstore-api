package com.example.restapimongodb.controllers;

import com.example.restapimongodb.CustomizedResponse;
import com.example.restapimongodb.models.Customer;
import com.example.restapimongodb.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class CustomerController
{
    @Autowired
    private CustomerService service;

    @GetMapping("/customers")
    public ResponseEntity getcustomers()
    {
        var customizedResponse = new CustomizedResponse("A list of customers", service.getCustomers());
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }


    @GetMapping("/customers/{id}")
    public ResponseEntity getACustomer(@PathVariable("id") String id)
    {
        CustomizedResponse customizedResponse = null;
        try {
            customizedResponse = new CustomizedResponse("Customer with id:" +id, Collections.singletonList(service.getACustomer(id)));
        } catch (Exception e) {
            customizedResponse = new CustomizedResponse(e.getMessage(), null);
            return new ResponseEntity(customizedResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }
    //customers/username?username=""&password?pword=""
    @GetMapping("/customers/username")
    public ResponseEntity getUsersByUsername(@RequestParam(value = "username") String username, @RequestParam(value = "password") String pword)
    {
        var customizedResponse = new CustomizedResponse("A list of user with username", service.getUserByUsername(username, pword));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/customers",consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public  ResponseEntity addCustomer(@RequestBody Customer customer)
    {

        service.insertIntoCustomers(customer);
        return new ResponseEntity("Customer has been added: "+customer, HttpStatus.OK);

    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteACustomer(@PathVariable("id") String id)
    {

        CustomizedResponse customizedResponse = null;
        try {
            service.deleteACustomer(id);

        } catch (Exception e) {
            customizedResponse = new CustomizedResponse(e.getMessage(), null);
            return new ResponseEntity(customizedResponse, HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity("Deleted Movie with id: "+id,HttpStatus.OK);
    }
}
