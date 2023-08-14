package com.notes.notesmanagement.controller;

import com.notes.notesmanagement.model.Exams;
import com.notes.notesmanagement.service.ExamsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamsController {

    private final ExamsService examsService;

    public ExamsController(ExamsService examsService) {
        this.examsService = examsService;
    }

    @GetMapping
    public List<Exams> getAllExams() {
        return examsService.getAllExams();
    }

    @GetMapping("/{id}")
    public Exams getExamsById(@PathVariable int id) {
        return examsService.getExamsById(id);
    }

    @PostMapping
    public void addExams(@RequestBody Exams exams) {
        examsService.addExams(exams);
    }

    @PutMapping("/{id}")
    public void updateExams(@PathVariable int id, @RequestBody Exams exams) {
        exams.setId_exam(id);
        examsService.updateExams(exams);
    }

    @DeleteMapping("/{id}")
    public void deleteExams(@PathVariable int id) {
        examsService.deleteExams(id);
    }

}