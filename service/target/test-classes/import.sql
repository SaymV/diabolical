-- Test fixture users.  Note how we stay well away from the autogenerated ID space.
insert into serviceuser(id, active, challenge, email, login) values(1000000, true, 'password', 'admin@headmaster.test', 'admin');
insert into userrole(id, rolename, login) values(1000000, 'HEADMASTER', 'admin');

insert into serviceuser(id, active, challenge, email, login) values(1000001, true, 'password-noroles', 'noroles@headmaster.test', 'noroles');

-- Test fixture students.
insert into student(id, firstname, lastname, active, expectedgraduationyear) values(1000000, 'Tim', 'Berners-Lee', true, 2016);
insert into student(id, firstname, lastname, active, expectedgraduationyear) values(1000001, 'Vint', 'Cerf', false, 2015);
insert into student(id, firstname, lastname, active, expectedgraduationyear) values(1000002, 'Don', 'Knuth', true, 2015);
insert into student(id, firstname, lastname, active, expectedgraduationyear) values(1000003, 'Ivan', 'Sutherland', false, 2012);
insert into student(id, firstname, lastname, active, expectedgraduationyear) values(1000004, 'Alan', 'Kay', true, 2014);

insert into major(id, collegeorschool, degree, discipline) values(1000000, 'Engineering', 'BS', 'Computer Science');
insert into major(id, collegeorschool, degree, discipline) values(1000001, 'Science','BA', 'Mathematics');

insert into student_major(student_id, majors_id, majors_order) values(1000002, 1000000, 0);
insert into student_major(student_id, majors_id, majors_order) values(1000002, 1000001, 1);

insert into student_minors(student_id, minors, minors_order) values(1000002, 'Music', 0);

-- Test fixture events.
insert into event(id, datetime, description, title) values(1000000, '2012-07-28 10:31:03', 'The big one', 'Summit');

insert into event_student(event_id, student_id, attendees_order) values(1000000, 1000002, 0);
insert into event_student(event_id, student_id, attendees_order) values(1000000, 1000000, 1);
insert into event_student(event_id, student_id, attendees_order) values(1000000, 1000001, 2);

-- Test fixture grades.
insert into gpa(id, gpa, term, year) values(1000000, 3.5, 0, 2016);
insert into gpa(id, gpa, term, year) values(1000001, 3.8, 2, 2015);

insert into student_gpa(student_id, grades_id) values(1000002, 1000000);
insert into student_gpa(student_id, grades_id) values(1000002, 1000001);

-- Test fixture grants.
insert into researchgrant(id, amount, facultymentor, title) values(1000000, 10000, 'Leonard Kleinrock', 'The Worldwide Web');

insert into researchgrant_student(grant_id, student_id, students_order) values(1000000, 1000000, 0);
insert into researchgrant_student(grant_id, student_id, students_order) values(1000000, 1000001, 1);
