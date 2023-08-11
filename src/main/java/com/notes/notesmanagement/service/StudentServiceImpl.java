package com.notes.notesmanagement.service;

import com.notes.notesmanagement.model.Student;
import com.notes.notesmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.update(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.delete(id);
    }
}