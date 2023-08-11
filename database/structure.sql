CREATE TABLE Student (
	std INT PRIMARY KEY,
	firstname VARCHAR(255) NOT NULL,
	lastname VARCHAR(255) NOT NULL,
	gender CHAR NOT NULL,
	level VARCHAR(2)
);

CREATE TABLE Courses (
	id_course SERIAL PRIMARY KEY,
	course_name VARCHAR(50) NOT NULL,
	credits INT NOT NULL
);

CREATE TABLE Exams (
	id_exams SERIAL PRIMARY KEY,
	percentage INT NOT NULL,
	id_course INT REFERENCES Courses(id_course)
);

CREATE TABLE take_exams (
	id_exams INT REFERENCES Exams(id_exams),
	id_student INT REFERENCES Student(id_student)
);
