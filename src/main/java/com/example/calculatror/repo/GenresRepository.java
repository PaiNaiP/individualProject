package com.example.calculatror.repo;

import com.example.calculatror.model.genres;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GenresRepository extends CrudRepository<genres, Integer> {
    public genres findBygenree(String genree);
    public List<genres> findBygenreeContains(String genree);

}
