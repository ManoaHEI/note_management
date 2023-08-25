package com.notes.notesmanagement.controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.notes.notesmanagement.model.Student;
import com.notes.notesmanagement.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/students")
public class StudentController {
    
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        try {
            Student student = studentService.getStudentById(id);
            return ResponseEntity.ok(student);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found", e);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable int id, @RequestBody Student student) {
        try {
            student.setStd(id);
            studentService.updateStudent(student);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found", e);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }
}
