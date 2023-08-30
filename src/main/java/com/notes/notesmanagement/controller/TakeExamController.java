package com.notes.notesmanagement.controller;

import com.notes.notesmanagement.model.TakeExam;
import com.notes.notesmanagement.model.TakeExamExtended;
import com.notes.notesmanagement.service.TakeExamService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/take_exam")
public class TakeExamController {
    private final TakeExamService takeExamService;

    public TakeExamController(TakeExamService takeExamService) {
        this.takeExamService = takeExamService;
    }

    @GetMapping
    public List<TakeExamExtended> getAllExamNote() {
        return takeExamService.getAllExamNote();
    }

    @GetMapping("/student/{id}")
    public List<TakeExamExtended> getExamNoteByIdStudent(@PathVariable int id) {
        return takeExamService.getExamNoteByIdStudent(id);
    }

    @GetMapping("/exam/{id}")
    public List<TakeExamExtended> getExamNoteByIdExam(@PathVariable int id) {
        return takeExamService.getExamNoteByIdExam(id);
    }

    @GetMapping("/id")
    public TakeExamExtended getExamNoteById(@RequestParam int idStudent, @RequestParam int idExam) {
        return takeExamService.getExamNoteById(idStudent, idExam);
    }

    @GetMapping("/average")
    public List<TakeExamExtended> findStudentAverageInACourse(@RequestParam String courseName , @RequestParam int std) {
        return takeExamService.findStudentAverageInACourse(courseName, std);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addTakeExam(@RequestBody TakeExam takeExam) {
        takeExamService.addTakeExam(takeExam);
    }

    @PutMapping("/student/{id}")
    public void updateByIdExam(@PathVariable int id , @RequestBody TakeExam takeExam) {
        takeExamService.updateByIdExam(takeExam);
    }

    @PutMapping("/exam/{id}")
    public void updateByIdStudent(@PathVariable int id , @RequestBody TakeExam takeExam) {
        takeExamService.updateByIdStudent(takeExam);
    }

    @DeleteMapping("/student/{id}")
    public void deleteByIdStudent(@PathVariable int id) {
        takeExamService.deleteByIdStudent(id);
    }

    @DeleteMapping("/exam/{id}")
    public void deleteByIdExam(@PathVariable int id) {
        takeExamService.deleteByIdExam(id);
    }

    @DeleteMapping
    public void deleteById(@RequestParam int idExam, @RequestParam int idStudent) {
        takeExamService.deleteById(idExam, idStudent);
    }

}