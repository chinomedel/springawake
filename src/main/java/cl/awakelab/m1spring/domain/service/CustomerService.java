package cl.awakelab.m1spring.domain.service;

import cl.awakelab.m1spring.persistence.entity.Customer;
import cl.awakelab.m1spring.persistence.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {


    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAll(){
        return repository.getAll();
    }

    public Optional<Customer> getOne(int customerId){
        return repository.getOne(customerId);
    }

    public Customer save(Customer customer){
        return repository.save(customer);
    }

    public boolean delete(int customerId){
        return getOne(customerId)
                .map(customer -> {
                    repository.delete(customerId);
                    return true;
                }).orElse(false);
    }

    /*Lambda:
    ([param]) -> { //codigo };
    */

    /*public Customer getOne(int customerId) {
        *//*Utilizo stream y lambda para filtrar los datos*//*
        List<Customer> list = new ArrayList<>();
        return list.stream()
                .filter(c -> c.getCustomerId() == customerId) // <- esto es el lambda
                .findFirst()
                .orElse(null);
    }*/

}
