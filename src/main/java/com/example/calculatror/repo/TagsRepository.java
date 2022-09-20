package com.example.calculatror.repo;

import com.example.calculatror.model.tags;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TagsRepository extends CrudRepository<tags, Integer> {
    public List<tags> findBytitleeContains(String titlee);
    public tags findBytitlee(String titlee);

}
