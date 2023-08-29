package com.notes.notesmanagement.service;

import com.notes.notesmanagement.model.TakeExam;

import java.util.List;

public interface TakeExamService {
    List<TakeExam> getAllExamNote();
    List<TakeExam> getExamNoteByIdStudent(int id);
    List<TakeExam> getExamNoteByIdExam(int id);
    TakeExam getExamNoteById(int idStudent , int idExam);
    void addTakeExam(TakeExam takeExam);
    void updateByIdExam(TakeExam takeExam);
    void updateByIdStudent(TakeExam takeExam);
    void deleteByIdStudent(int id);
    void deleteByIdExam(int id);
    void deleteById(int idExam , int idStudent);
}