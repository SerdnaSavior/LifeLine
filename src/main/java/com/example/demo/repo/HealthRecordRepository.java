package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.HealthRecords;

@Repository
public interface HealthRecordRepository extends JpaRepository<HealthRecords, Long> {
}
