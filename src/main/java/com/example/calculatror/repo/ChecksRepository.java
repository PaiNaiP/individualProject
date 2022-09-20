package com.example.calculatror.repo;

import com.example.calculatror.model.checks;
import com.example.calculatror.model.tickets;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChecksRepository extends CrudRepository<checks, Integer> {
    public List<checks> findBydatingContains(String dating);
    public List<checks> findBydating(String dating);
}
