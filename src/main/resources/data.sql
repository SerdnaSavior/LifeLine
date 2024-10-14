-- Insert admin user with role 'ADMIN'
INSERT INTO USERS (username, email, password, role) 
VALUES ('admin', 'admin@example.com', '123', 'ADMIN');
INSERT INTO USERS (username, email, password, role) 
VALUES ('user', 'user@example.com', '123', 'patient');