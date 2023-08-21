package com.notes.notesmanagement.service;

import com.notes.notesmanagement.model.Exams;
import com.notes.notesmanagement.repository.ExamsRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Service;

import java.util.List;

@Service
=======

import java.util.List;

>>>>>>> 906da8a4a076c07108be5d177ed9bf1ec5a14db9
public class ExamsServiceImpl implements ExamsService {

    private final ExamsRepository examsRepository;

    public ExamsServiceImpl(ExamsRepository examsRepository) {
        this.examsRepository = examsRepository;
    }

    @Override
    public List<Exams> getAllExams() {
        return examsRepository.findAll();
    }

    @Override
    public Exams getExamsById(int id) {
        return examsRepository.findById(id);
    }

    @Override
    public void addExams(Exams exams) {
        examsRepository.addExams(exams);
    }

    @Override
    public void updateExams(Exams exams) {
        examsRepository.update(exams);
    }

    @Override
    public void deleteExams(int id) {
        examsRepository.delete(id);
    }

}
