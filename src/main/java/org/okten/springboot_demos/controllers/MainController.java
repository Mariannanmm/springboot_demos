package org.okten.springboot_demos.controllers;

import org.okten.springboot_demos.models.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    List<Customer> customerList = new ArrayList<>();

    public MainController() {
        customerList.add(new Customer(1, "Biba"));
        customerList.add(new Customer(2, "Boba"));
        customerList.add(new Customer(3, "Aboba"));
        customerList.add(new Customer(4, "Boloba"));
        customerList.add(new Customer(5, "Labuba"));
    }




    @GetMapping("/")
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("home get", HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<String> home_post() {
        return new ResponseEntity<>("home post", HttpStatus.CREATED);
    }
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
    //@PostMapping("/customers")
    //public ResponseEntity<List<Customer>> saveCustomer(
    //        @RequestParam int id,
    //        @RequestParam String name) {
    //    this.customerList.add(new Customer(id, name));
    //    return new ResponseEntity<>(this.customerList, HttpStatus.CREATED);
    //}
    @PostMapping("/customers")
    public void saveCustomerJSON(@RequestBody Customer customer) {
        customerList.add(customer);
        System.out.println(customerList);
    }
}
