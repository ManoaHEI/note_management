package com.notes.notesmanagement.service;

import com.notes.notesmanagement.model.Student;
import java.util.List;

public interface StudentService {
    // Simple CRUD
    List<Student> getAllStudents();
    Student getStudentById(int id);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int id);

    // Special request

}