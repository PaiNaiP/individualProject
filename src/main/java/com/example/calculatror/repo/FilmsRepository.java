package com.example.calculatror.repo;

import com.example.calculatror.model.films;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmsRepository extends CrudRepository<films, Integer> {
    public List<films> findBytitleContains(String title);
    public films findBytitle(String title);

}
