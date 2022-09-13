package com.example.calculatror.repo;

import com.example.calculatror.model.PhoneNumber;
import org.springframework.data.repository.CrudRepository;

public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Integer> {
    PhoneNumber findByNumber(String number);
}
