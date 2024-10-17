-- Insert admin user with role 'ADMIN'
INSERT INTO USERS (username, email, password, role,first_name, last_name, dob)
VALUES ('admin', 'admin@example.com', '123', 'ADMIN','John', 'Doe', '01-01-1980');
INSERT INTO USERS (username, email, password, role,first_name, last_name, dob) 
VALUES ('user', 'user@example.com', '123', 'patient','Jane', 'Doe', '1980-01-02');
INSERT INTO patients (
    first_name,last_name, dob, gender, blood_type, marital_status, 
    address, city, state, postal_code, phone_number, email, 
    emergency_contact_name, emergency_contact_phone, 
    allergies, height, weight, blood_pressure, medical_history, 
    insurance_provider, insurance_policy_number, insurance_expiration_date, insurance_type, 
    date_of_registration, doctor_assigned, appointment_history
) VALUES (
    'John', 'Doe', '1985-06-15', 'Male', 'O+', 'Single', 
    '123 Main St', 'New York', 'NY', '10001', '555-1234', 'john.doe@example.com', 
    'Jane Doe', '555-5678', 
    'Pollen, Penicillin', '180', '75', '120/80', 'No major medical issues', 
    'HealthCare Inc.', 'INS123456789', '2025-06-30', 'Full Coverage', 
    '2024-01-01', 'Dr. Smith', '2024-01-15: Initial Consultation; 2024-03-20: Follow-up'
);
INSERT INTO patients (
   first_name,last_name, dob, gender, blood_type, marital_status, 
    address, city, state, postal_code, phone_number, email, 
    emergency_contact_name, emergency_contact_phone, 
    allergies, height, weight, blood_pressure, medical_history, 
    insurance_provider, insurance_policy_number, insurance_expiration_date, insurance_type, 
    date_of_registration, doctor_assigned, appointment_history
) VALUES (
    'Jane', 'Doe', '1985-06-15', 'Male', 'O+', 'Single', 
    '123 Main St', 'New York', 'NY', '10001', '555-1234', 'john.doe@example.com', 
    'Jane Doe', '555-5678', 
    'Pollen, Penicillin', '180', '75', '120/80', 'No major medical issues', 
    'HealthCare Inc.', 'INS123456789', '2025-06-30', 'Full Coverage', 
    '2024-01-01', 'Dr. Smith', '2024-01-15: Initial Consultation; 2024-03-20: Follow-up'
);