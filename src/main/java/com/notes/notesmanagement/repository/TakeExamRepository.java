package com.notes.notesmanagement.repository;

import com.notes.notesmanagement.model.TakeExam;

import java.util.List;

public interface TakeExamRepository {
    List<TakeExam> findAllExamNote();
    List<TakeExam> findExamNoteByIdStudent(int id);
    List<TakeExam> findExamNoteByIdExam(int id);
    TakeExam findExamNoteById(int idStudent , int idExam);
    void addTakeExam(TakeExam takeExam);
    void updateByIdExam(TakeExam takeExam);
    void updateByIdStudent(TakeExam takeExam);
    void deleteByIdStudent(int id);
    void deleteByIdExam(int id);
    void deleteById(int idExam , int idStudent);
}