package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Patients;

public interface PatientService {    

List<Patients> getAllPatients();
void save(Patients patients);
Patients getByIdPatients(Integer id);
List<Patients> searchPatientsByNameOrId(String searchTerm);
void deleteViaId(int id);

}

