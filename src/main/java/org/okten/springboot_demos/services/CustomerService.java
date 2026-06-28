package org.okten.springboot_demos.services;

import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import org.okten.springboot_demos.dao.CustomerDAO;
import org.okten.springboot_demos.dto.CustomerDTO;
import org.okten.springboot_demos.models.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerDAO customerDAO;

    public CustomerDTO findAll() {
        List<Customer> all = customerDAO.findAll();
        List<CustomerDTO> collect = all.stream().map(customer -> new CustomerDTO(customer.getName(),customer.getAge())).collect(Collectors.toList());
        return (CustomerDTO) collect;
    }
}
