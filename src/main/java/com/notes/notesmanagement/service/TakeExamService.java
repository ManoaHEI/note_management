package com.notes.notesmanagement.service;

import com.notes.notesmanagement.model.TakeExam;
import com.notes.notesmanagement.model.TakeExamExtended;

import java.util.List;

public interface TakeExamService {
    List<TakeExamExtended> getAllExamNote();
    List<TakeExamExtended> getExamNoteByIdStudent(int id);
    List<TakeExamExtended> getExamNoteByIdExam(int id);
    TakeExamExtended getExamNoteById(int idStudent , int idExam);
    List<TakeExamExtended> findStudentAverageInACourse(String courseName , int std);
    void addTakeExam(TakeExam takeExam);
    void updateByIdExam(TakeExam takeExam);
    void updateByIdStudent(TakeExam takeExam);
    void deleteByIdStudent(int id);
    void deleteByIdExam(int id);
    void deleteById(int idExam , int idStudent);
}