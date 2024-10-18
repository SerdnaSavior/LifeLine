package com.example.demo.service;

import com.example.demo.model.Appointments;
import com.example.demo.repo.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointments saveAppointment(Appointments appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointments> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointments getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}