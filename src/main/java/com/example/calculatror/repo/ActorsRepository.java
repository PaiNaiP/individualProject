package com.example.calculatror.repo;

import com.example.calculatror.model.actors;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActorsRepository extends CrudRepository<actors, Integer> {
    public List<actors> findBysurnameContains(String surname);
    public actors findBysurname(String surname);
}
