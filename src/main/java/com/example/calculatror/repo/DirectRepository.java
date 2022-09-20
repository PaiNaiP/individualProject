package com.example.calculatror.repo;

import com.example.calculatror.model.direct;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DirectRepository extends CrudRepository<direct, Integer> {
    public List<direct> findBysurnameyContains(String surnamey);
    public direct findBysurnamey(String surnamey);

}