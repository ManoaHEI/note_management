# note_management

This Java application provides functionality for managing students, courses, and exams, including the ability for students to participate in exams. It implements basic CRUD (Create, Read, Update, Delete) operations for students, courses, and exams.

## Table of Contents
- [Features](#features)
- [Setup](#setup)
- [Usage](#usage)

## Features

1. Student Management:
   - Create a new student with details such as std, username, gender, and level information.
   - Retrieve information about a specific student.
   - Update student details.
   - Delete a student.

2. Course Management:
   - Add a new course with information like course code, title, and credits.
   - Get details about a specific course.
   - Update course information.
   - Delete a course.

3. Exam Participation:
   - Enroll a student in an exam.
   - Record exam scores for students.
   - Retrieve exam scores for students.

- [Technologies Used](#technologies-used)
4. Exam Management:
   - Create new exams for courses.
   - Get exam details.
   - Update exam information.
   - Delete an exam.

## Setup

1. Clone the repository.
2. Install the required dependencies using Maven.
3. Set up your PostgreSQL database and update the database configuration in the application properties. You can find the path of structure here /database/structure.sql
4. Run the application.

## Usage

1. Access the application's API using tools like Postman, cURL, or any API testing tool.
2. Use the provided API endpoints to perform CRUD operations on students, courses, exams, and exam participation.
