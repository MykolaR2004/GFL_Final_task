package com.example.datingagency.repositories;

import com.example.datingagency.data.DatingTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatingTableRepository extends JpaRepository<DatingTable, Integer> {
    List<DatingTable> findById(int id);

}