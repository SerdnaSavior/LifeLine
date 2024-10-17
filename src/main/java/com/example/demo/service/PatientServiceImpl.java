package com.example.demo.service;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Patients;
import com.example.demo.repo.PatientRepository;

@Service
public class PatientServiceImpl
    implements PatientService {
   
    @Autowired private PatientRepository patientRepo;
 
    @Override public List<Patients> getAllPatients()
    {
        return patientRepo.findAll();
       
    }
    
 
    @Override public void save(Patients patient)
    {    
        patientRepo.save(patient);
    }
 
    @Override public Patients getByIdPatients(Integer id)
    {
        Optional<Patients> optional = patientRepo.findById(id);
        Patients user = null;
        if (optional.isPresent())
            user = optional.get();
        else
            throw new RuntimeException(
                "Patients not found for id : " + id);
        return user;
    }
 
    @Override public void deleteViaId(int id)
    {
        patientRepo.deleteById(id);
    }
    @Override
    public List<Patients> searchPatientsByNameOrId(String searchTerm) {
        // Ensure that the search term is not null or empty
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            throw new IllegalArgumentException("Search term must not be empty");
        }
        try {
            Long id = Long.parseLong(searchTerm);
            return patientRepo.findByNameOrId(null, id); // Search by ID
        } catch (NumberFormatException e) {
            return patientRepo.findByNameOrId(searchTerm, null); // Search by last name
        }
    }
    
}