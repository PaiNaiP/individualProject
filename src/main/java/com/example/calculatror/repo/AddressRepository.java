package com.example.calculatror.repo;

import com.example.calculatror.model.Adress;
import org.apache.tomcat.jni.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Adress, Integer> {
    Adress findByStreet(String street);
}
