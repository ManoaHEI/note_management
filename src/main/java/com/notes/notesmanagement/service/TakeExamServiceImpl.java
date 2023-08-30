package com.notes.notesmanagement.service;

import com.notes.notesmanagement.model.TakeExam;
import com.notes.notesmanagement.model.TakeExamExtended;
import com.notes.notesmanagement.repository.TakeExamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TakeExamServiceImpl implements TakeExamService {

    private final TakeExamRepository takeExamRepository;

    public TakeExamServiceImpl(TakeExamRepository takeExamRepository) {
        this.takeExamRepository = takeExamRepository;
    }

    @Override
    public List<TakeExamExtended> getAllExamNote() {
        return takeExamRepository.findAllExamNote();
    }

    @Override
    public List<TakeExamExtended> getExamNoteByIdStudent(int id) {
        return takeExamRepository.findExamNoteByIdStudent(id);
    }

    @Override
    public List<TakeExamExtended> getExamNoteByIdExam(int id) {
        return takeExamRepository.findExamNoteByIdExam(id);
    }

    @Override
    public TakeExamExtended getExamNoteById(int idStudent, int idExam) {
        return takeExamRepository.findExamNoteById(idStudent , idExam);
    }

    @Override
    public List<TakeExamExtended> findStudentAverageInACourse(String courseName , int std) {
        return takeExamRepository.findStudentAverageInACourse(courseName, std);
    }

    @Override
    public void addTakeExam(TakeExam takeExam) {
        takeExamRepository.addTakeExam(takeExam);
    }

    @Override
    public void updateByIdExam(TakeExam takeExam) {
        takeExamRepository.updateByIdExam(takeExam);
    }

    @Override
    public void updateByIdStudent(TakeExam takeExam) {
        takeExamRepository.updateByIdStudent(takeExam);
    }

    @Override
    public void deleteByIdStudent(int id) {
        takeExamRepository.deleteByIdStudent(id);
    }

    @Override
    public void deleteByIdExam(int id) {
        takeExamRepository.deleteByIdExam(id);
    }

    @Override
    public void deleteById(int idExam, int idStudent) {
        takeExamRepository.deleteById(idExam , idStudent);
    }
}
