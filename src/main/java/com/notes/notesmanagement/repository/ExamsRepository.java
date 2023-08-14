package com.notes.notesmanagement.repository;

import com.notes.notesmanagement.model.Exams;
import java.util.List;

public interface ExamsRepository {
    List<Exams> findAll();
    Exams findById(int id);
    void addExams(Exams exams);
    void update(Exams exams);
    void delete(int id);
}