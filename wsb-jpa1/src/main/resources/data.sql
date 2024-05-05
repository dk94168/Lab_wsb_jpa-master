-- insert into address (id, address_line1, address_line2, city, postal_code)
--            values (1, 'xx', 'yy', 'city', '62-030');


insert into address (address_line1, address_line2, city, postal_code)
     values ('pl. Warszawy 1', '', 'Wrocław', '55-612'),
            ('Grunwaldzka 12', '', 'Wrocław', '54-320'),
            ('Szewska 123/11', 'Graniczna 11/3', 'Poznań', '78-210'),
            ('Rakietowa 10a', 'Kościuszki 12/5', 'Toruń', '29-421'),
            ('Karmelkowa 16/1', 'Paprotna 17b', 'Legnica', '42-018'),
            ('Stawowa 16/4', '', 'Opole', '32-975');

insert into doctor (first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
     values ('Jan', 'Nowak', '32 128-12-54', 'jn@doctor.com', '1', 'SURGEON', '1'),
            ('Tomasz', 'Kowalski', '45 341-26-43', 'tk@doctor.com', '2', 'OCULIST', '2'),
            ('Michał', 'Stępień', '71 109-41-78', 'ms@doctor.com', '3', 'DERMATOLOGIST', '5');

insert into patient (date_of_birth, email, first_name, last_name, patient_number, telephone_number, premium, address_id)
     values ('1989-02-16', 'pk@patient.com', 'Piotr', 'Kozioł', '1', '753-231-982', '0', '3'),
            ('1995-06-20', 'mb@patient.com', 'Michał', 'Bąk', '2', '540-251-641', '0', '4'),
            ('2000-09-03', 'tp@patient.com', 'Tymon', 'Potocki', '3', '890-153-861', '1', '6');

insert into visit (description, time, doctor_id, patient_id)
     values ('visit oculist', '2024-02-10 15:00:00', '2', '1'),
            ('visit surgeon', '2024-03-21 12:15:00', '1', '2'),
            ('visit oculist', '2024-01-12 16:30:00', '2', '2'),
            ('visit dermatologist', '2024-04-18 16:30:00', '3', '3');

insert into medical_treatment (description, type, visit_id)
    values ('order test: rtg', 'RTG', '1'),
           ('order test: rtg', 'RTG', '2'),
           ('order test: usg', 'USG', '3'),
           ('order test: allergy', 'ALLERGY', '4');

