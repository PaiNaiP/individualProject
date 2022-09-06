package com.example.calculatror.repo;

import com.example.calculatror.model.films;
import com.example.calculatror.model.news;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface filmsRepository extends CrudRepository<films, Integer> {
    public List<films> findByTitle(String title);
    public List<films> findByTitleContains(String title);
}

