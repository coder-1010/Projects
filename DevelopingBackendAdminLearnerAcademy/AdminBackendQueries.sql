create table SubjectsAvailable(subjects varchar(30),classes varchar(30));
insert into SubjectsAvailable values('subject 1','class 1'),('subject 2','class 1'),('subject 3','class 1'),
									('subject 1','class 2'),('subject 2','class 2'),('subject 3','class 2'),
                                    ('subject 1','class 3'),('subject 2','class 3'),('subject 3','class 3'),
                                    ('subject 1','class 4'),('subject 2','class 4'),('subject 3','class 4'),
									('subject 1','class 5'),('subject 2','class 5'),('subject 3','class 5'),
                                    ('subject 1','class 6'),('subject 2','class 6'),('subject 3','class 6');
create table TeachersAvailable(teachers varchar(50));
insert into TeachersAvailable values ('teacher 1'),('teacher 2'),('teacher 3'),('teacher 4'),('teacher 5'),('teacher 6');
create table ClassesAvailable(classes varchar(30));
insert into ClassesAvailable values ('class 1'),('class 2'),('class 3'),('class 4'),('class 5'),('class 6');
ALTER TABLE ClassesAvailable ADD CONSTRAINT UniqueClasses UNIQUE (classes);
ALTER TABLE TeachersAvailable ADD CONSTRAINT UniqueTeachers UNIQUE (teachers);
create table AssignClasses(teachers varchar(50),subjects varchar(30),classes varchar(30));
insert into AssignClasses values ('teacher 1','subject 1','class 1'),('teacher 1','subject 2','class 1'),	('teacher 1','subject 3','class 1'),
								 ('teacher 2','subject 1','class 2'),('teacher 2','subject 2','class 2'),	('teacher 2','subject 3','class 2'),
                                 ('teacher 3','subject 1','class 3'),('teacher 3','subject 2','class 3'),	('teacher 3','subject 3','class 3'),
                                 ('teacher 4','subject 1','class 4'),('teacher 4','subject 2','class 4'),	('teacher 4','subject 3','class 4'),
								 ('teacher 5','subject 1','class 5'),('teacher 5','subject 2','class 5'),	('teacher 5','subject 3','class 5'),
                                 ('teacher 6','subject 1','class 6'),('teacher 6','subject 2','class 6'),	('teacher 6','subject 3','class 6');
create table AssignStudents(students varchar(50),classes varchar(20));
insert into AssignStudents values ('student 1','class 1'),('student 2','class 1'),('student 3','class 1'),
									('student 4','class 2'),('student 5','class 2'),('student 6','class 2'),
                                    ('student 7','class 3'),('student 8','class 3'),('student 9','class 3'),
                                    ('student 10','class 4'),('student 11','class 4'),('student 12','class 4'),
									('student 13','class 5'),('student 14','class 5'),('student 15','class 5'),
                                    ('student 16','class 6'),('student 17','class 6'),('student 18','class 6');
ALTER TABLE AssignStudents ADD CONSTRAINT Uniquetudents UNIQUE (students);
ALTER TABLE AssignStudents MODIFY classes varchar(20) NOT NULL;