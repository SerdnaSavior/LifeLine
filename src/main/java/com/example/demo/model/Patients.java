package com.example.demo.model;

import java.time.LocalDate;
import java.time.Period;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity()
public class Patients {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    // Personal Information
    private Long id;
    private String first_name;
    private String last_name;
    private LocalDate dob;
    private String gender;
    private String blood_type;
    private String marital_status;    

    // Contact Information
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String phone_number;
    private String email;

    // Emergency Contact Information
    private String emergency_contact_name;
    private String emergency_contact_phone;
    

    // Medical Information
    private String allergies;     
    private Long height;
    private Long weight;
    private String blood_pressure;
    private String medical_history;

    // Insurance Information
    private String insurance_provider;
    private String insurance_policy_number;
    private LocalDate insurance_expiration_date;
    private String insurance_type;

    // Administrative Details
    private LocalDate date_of_registration;
    private String doctor_assigned;
    private String appointment_history;

    // Default Constructor (No-Arg)
    public Patients() {
    }

    // Parameterized Constructor (all fields)
    public Patients(Long id, String first_name,String last_name, LocalDate dob, String gender, String blood_type, String marital_status,
                   String address, String city, String state, String postalCode, String phone_number, String email,
                   String emergency_contact_name, String emergency_contact_phone, String allergies,
                   Long height, Long weight, String blood_pressure, String medical_history,
                   String insurance_provider, String insurance_policy_number, LocalDate insurance_expiration_date, String insurance_type,
                   LocalDate date_of_registration, String doctor_assigned, String appointment_history) {
        this.id = id;
        this.first_name = first_name;
        this.last_name= last_name;
        this.dob = dob;
        this.gender = gender;
        this.blood_type = blood_type;
        this.marital_status = marital_status;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.phone_number = phone_number;
        this.email = email;
        this.emergency_contact_name = emergency_contact_name;
        this.emergency_contact_phone = emergency_contact_phone;
        this.allergies = allergies;
        this.height = height;
        this.weight = weight;
        this.blood_pressure = blood_pressure;
        this.medical_history = medical_history;
        this.insurance_provider = insurance_provider;
        this.insurance_policy_number = insurance_policy_number;
        this.insurance_expiration_date = insurance_expiration_date;
        this.insurance_type = insurance_type;
        this.date_of_registration = date_of_registration;
        this.doctor_assigned = doctor_assigned;
        this.appointment_history = appointment_history;
    }
    // Getter method to calculate age based on dob
    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }


    // Getters and Setters

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    // Personal Information
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    // Contact Information
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal_code() {
        return postalCode;
    }

    public void setPostal_code(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Emergency Contact Information
    public String getEmergency_contact_name() {
        return emergency_contact_name;
    }

    public void setEmergency_contact_name(String emergency_contact_name) {
        this.emergency_contact_name = emergency_contact_name;
    }

    public String getEmergency_contact_phone() {
        return emergency_contact_phone;
    }

    public void setEmergency_contact_phone(String emergency_contact_phone) {
        this.emergency_contact_phone = emergency_contact_phone;
    }

    // Medical Information
    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getBlood_pressure() {
        return blood_pressure;
    }

    public void setBlood_pressure(String blood_pressure) {
        this.blood_pressure = blood_pressure;
    }

    public String getMedical_history() {
        return medical_history;
    }

    public void setMedical_history(String medical_history) {
        this.medical_history = medical_history;
    }

    // Insurance Information
    public String getInsurance_provider() {
        return insurance_provider;
    }

    public void setInsurance_provider(String insurance_provider) {
        this.insurance_provider = insurance_provider;
    }

    public String getInsurance_policy_number() {
        return insurance_policy_number;
    }

    public void setInsurance_policy_number(String insurance_policy_number) {
        this.insurance_policy_number = insurance_policy_number;
    }

    public LocalDate getInsurance_expiration_date() {
        return insurance_expiration_date;
    }

    public void setInsurance_expiration_date(LocalDate insurance_expiration_date) {
        this.insurance_expiration_date = insurance_expiration_date;
    }

    public String getInsurance_type() {
        return insurance_type;
    }

    public void setInsurance_type(String insurance_type) {
        this.insurance_type = insurance_type;
    }

    // Administrative Details
    public LocalDate getDate_of_registration() {
        return date_of_registration;
    }

    public void setDate_of_registration(LocalDate date_of_registration) {
        this.date_of_registration = date_of_registration;
    }

    public String getDoctor_assigned() {
        return doctor_assigned;
    }

    public void setDoctor_assigned(String doctor_assigned) {
        this.doctor_assigned = doctor_assigned;
    }

    public String getAppointment_history() {
        return appointment_history;
    }

    public void setAppointment_history(String appointment_history) {
        this.appointment_history = appointment_history;
    }
}