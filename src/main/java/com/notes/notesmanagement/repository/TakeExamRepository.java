package com.notes.notesmanagement.repository;

import com.notes.notesmanagement.model.TakeExam;
import com.notes.notesmanagement.model.TakeExamExtended;

import java.util.List;

public interface TakeExamRepository {
    List<TakeExamExtended> findAllExamNote();
    List<TakeExamExtended> findExamNoteByIdStudent(int id);
    List<TakeExamExtended> findExamNoteByIdExam(int id);
    TakeExamExtended findExamNoteById(int idStudent , int idExam);
    List<TakeExamExtended> findStudentAverageInACourse(String courseName , int std);
    void addTakeExam(TakeExam takeExam);
    void updateByIdExam(TakeExam takeExam);
    void updateByIdStudent(TakeExam takeExam);
    void deleteByIdStudent(int id);
    void deleteByIdExam(int id);
    void deleteById(int idExam , int idStudent);
}