-- Insert admin user with role 'ADMIN'
INSERT INTO USERS (username, email, password, role,first_name, last_name, dob)
VALUES ('admin', 'admin@example.com', '123', 'ADMIN','John', 'Doe', '01-01-1980');
INSERT INTO USERS (username, email, password, role,first_name, last_name, dob) 
VALUES ('user', 'user@example.com', '123', 'patient','Jane', 'Doe', '1980-01-02');