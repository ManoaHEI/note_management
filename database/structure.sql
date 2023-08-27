CREATE TABLE IF NOT EXISTS Student (
	std INT PRIMARY KEY,
	firstname VARCHAR(255) NOT NULL,
	lastname VARCHAR(255) NOT NULL,
	gender CHAR NOT NULL,
	level VARCHAR(2)
);

CREATE TABLE IF NOT EXISTS Courses (
	id_course SERIAL PRIMARY KEY,
	course_name VARCHAR(50) NOT NULL UNIQUE,
	credits INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Exams (
	id_exams SERIAL PRIMARY KEY,
	percentage INT NOT NULL,
	id_course INT REFERENCES Courses(id_course)
);

CREATE TABLE IF NOT EXISTS take_exams (
	id_exams INT REFERENCES Exams(id_exams),
	id_student INT REFERENCES Student(std),
    note FLOAT NOT NULL CHECK (note >= 0 AND note <= 20)
);