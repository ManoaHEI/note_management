package com.notes.notesmanagement.service;

import com.notes.notesmanagement.model.TakeExam;
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
    public List<TakeExam> getAllExamNote() {
        return takeExamRepository.findAllExamNote();
    }

    @Override
    public List<TakeExam> getExamNoteByIdStudent(int id) {
        return takeExamRepository.findExamNoteByIdStudent(id);
    }

    @Override
    public List<TakeExam> getExamNoteByIdExam(int id) {
        return takeExamRepository.findExamNoteByIdExam(id);
    }

    @Override
    public TakeExam getExamNoteById(int idStudent, int idExam) {
        return takeExamRepository.findExamNoteById(idStudent , idExam);
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
