package com.notes.notesmanagement.service;

import com.notes.notesmanagement.model.Student;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Integer id);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Integer id);
}