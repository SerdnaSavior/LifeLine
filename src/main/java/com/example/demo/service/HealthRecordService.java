package com.example.demo.service;

import com.example.demo.model.HealthRecords;
import com.example.demo.repo.HealthRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthRecordService {

    @Autowired
    private HealthRecordRepository healthRecordRepository;

    public HealthRecords saveHealthRecord(HealthRecords healthRecord) {
        return healthRecordRepository.save(healthRecord);
    }

    public List<HealthRecords> getAllHealthRecords() {
        return healthRecordRepository.findAll();
    }

    public HealthRecords getHealthRecordById(Long id) {
        return healthRecordRepository.findById(id).orElse(null);
    }

    public void deleteHealthRecord(Long id) {
        healthRecordRepository.deleteById(id);
    }
}