package com.example.demo.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Patients;


@Repository
public interface PatientRepository extends JpaRepository<Patients,Integer> {
    // Custom query to find patients by name or ID
    @Query("SELECT p FROM Patients p WHERE p.last_name LIKE %:searchTerm% OR p.id = :id")
    List<Patients> findByNameOrId(@Param("searchTerm") String searchTerm, @Param("id") Long id);

}