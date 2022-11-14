package com.crud.app.controller;

import com.crud.app.model.Customer;
import com.crud.app.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        Customer cus = customerService.findCustomerById((long) id);
        return ResponseEntity.status(HttpStatus.OK).body(cus);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Long> deleteCustomerById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.deleteCustomerById((long) id));
    }

    @PostMapping("/post")
    @ResponseBody
    public Customer postCustomer(@RequestBody Customer customer) {
        return customerService.insertNewCustomer(customer);
    }

    @PutMapping("/put")
    @ResponseBody
    public Customer putCustomer(@RequestBody Customer customer) {
        return customerService.putCustomer(customer);
    }
}