package com.example.calculatror.repo;

import com.example.calculatror.model.mpgusk;
import org.springframework.data.repository.CrudRepository;

public interface MpgRepository extends CrudRepository<mpgusk, Integer> {
    mpgusk findByKurs(int Kurs);
}
