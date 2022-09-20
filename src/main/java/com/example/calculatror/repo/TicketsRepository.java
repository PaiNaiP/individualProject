package com.example.calculatror.repo;

import com.example.calculatror.model.tickets;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketsRepository extends CrudRepository<tickets, Integer> {
        public List<tickets> findBydateContains(String date);
        public tickets findBydate(String date);
    }