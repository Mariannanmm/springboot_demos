package org.okten.springboot_demos.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.okten.springboot_demos.models.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CustomerDAO {
    @PersistenceContext
    private EntityManager entityManager;


    public void save(Customer customer) {
        entityManager.persist(customer);
    }


    public void update(Customer customer) {
        entityManager.merge(customer);
    }
    public List<Customer> findAll() {
        //return entityManager.createNativeQuery("select * from customer", Customer.class).getResultList();
        return entityManager.createQuery("select c from Customer c", Customer.class).getResultList();
    }

    public Customer findOne(int id) {
        return entityManager.find(Customer.class, id);
    }

    public void delete(int id) {
        entityManager.remove(findOne(id));
    }

}
