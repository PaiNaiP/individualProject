package com.example.calculatror.repo;

import com.example.calculatror.model.agelimit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AgeLimitRepository extends CrudRepository<agelimit, Integer> {
    public List<agelimit> findByagelimitrusContains(String agelimitrus);
    public agelimit findByagelimitrus(String agelimitrus);

}
