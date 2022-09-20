package com.example.calculatror.repo;

import com.example.calculatror.model.reviews;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewsRepository extends CrudRepository<reviews, Integer> {
    public List<reviews> findBytitlingContains(String titling);
    public List<reviews> findBytitling(String titling);

}
