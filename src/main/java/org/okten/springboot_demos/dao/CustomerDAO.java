package org.okten.springboot_demos.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.okten.springboot_demos.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CustomerDAO extends JpaRepository<Customer, Integer> {

    @Query("select c from Customer c where c.name=:name" )
    List<Customer> findByName(@Param("name") String Name);


}
