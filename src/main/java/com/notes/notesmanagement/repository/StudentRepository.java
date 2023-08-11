package com.notes.notesmanagement.repository;

import com.notes.notesmanagement.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    Student findById(int id);
    void addStudent(Student student);
    void update(Student student);
    void delete(int id);
}