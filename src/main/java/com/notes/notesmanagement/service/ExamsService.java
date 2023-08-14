package com.notes.notesmanagement.service;

import com.notes.notesmanagement.model.Exams;

import java.util.List;

public interface ExamsService {
    List<Exams> getAllExams();
    Exams getExamsById(int id);
    void addExams(Exams exams);
    void updateExams(Exams exams);
    void deleteExams(int id);
}
