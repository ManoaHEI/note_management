package com.notes.notesmanagement.controller;

import com.notes.notesmanagement.model.TakeExam;
import com.notes.notesmanagement.service.TakeExamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/take_exam")
public class TakeExamController {
    private final TakeExamService takeExamService;

    public TakeExamController(TakeExamService takeExamService) {
        this.takeExamService = takeExamService;
    }

    @GetMapping("/allExamNote")
    public List<TakeExam> getAllExamNote() {
        return takeExamService.getAllExamNote();
    }


}
