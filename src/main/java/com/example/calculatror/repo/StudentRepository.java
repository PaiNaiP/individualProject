package com.example.calculatror.repo;

import com.example.calculatror.model.student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<student, Integer> {
    student findByZvanie(String Zvanie);
}
