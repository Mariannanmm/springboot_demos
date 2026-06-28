package org.okten.springboot_demos.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.okten.springboot_demos.dao.CustomerDAO;
import org.okten.springboot_demos.dto.CustomerDTO;
import org.okten.springboot_demos.models.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    private CustomerDAO customerDAO;

   @GetMapping ("")
   public ResponseEntity<List<CustomerDTO>> getCustomers() {
       List<Customer> all = customerDAO.findAll();
       List<CustomerDTO> collect = all.stream().map(customer -> new CustomerDTO(customer.getName(),customer.getAge())).collect(Collectors.toList());
       return new ResponseEntity<>(collect, HttpStatus.OK);
   }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
       Optional<Customer> byId = customerDAO.findById(id);
        return new ResponseEntity<>(byId.get(), HttpStatus.OK);
    }

    @PostMapping("")
    public void saveCustomerJSON(@RequestBody @Valid CustomerDTO customerDTO) {
       Customer customer = new Customer();
       customer.setName(customerDTO.getCustomerName());
       customer.setAge(customerDTO.getCustomerAge());
       customerDAO.save(customer);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable int id) {
       customerDAO.deleteById(id);
        return  new ResponseEntity<>(customerDAO.findAll(), HttpStatus.OK);
    }
    @PatchMapping("")
    public ResponseEntity<List<Customer>> updateCustomer(@RequestBody Customer customer) {
       customerDAO.save(customer);
       return new ResponseEntity<>(customerDAO.findAll(), HttpStatus.OK);
    }
    @GetMapping("/findBy/name/{name}")
    public List<Customer> findByNameQuery(@PathVariable  String name) {
       return customerDAO.findByName(name);
    }

}

