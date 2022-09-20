package com.example.calculatror.repo;

import com.example.calculatror.model.places;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlacesRepository extends CrudRepository<places, Integer> {
    public places findByplace(Integer place);
    public List<places> findByplaceContains(Integer place);
}
