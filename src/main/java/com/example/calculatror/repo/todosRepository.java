package com.example.calculatror.repo;

import com.example.calculatror.model.films;
import com.example.calculatror.model.todos;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface todosRepository extends CrudRepository<todos, Integer> {
    public List<todos> findByTitle(String title);
    public List<todos> findByTitleContains(String title);
}

