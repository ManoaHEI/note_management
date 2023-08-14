package com.notes.notesmanagement.service;

import com.notes.notesmanagement.model.Courses;
import com.notes.notesmanagement.repository.CoursesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService {

    private final CoursesRepository coursesRepository;

    public CoursesServiceImpl(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    @Override
    public List<Courses> getAllCourses() {
        return coursesRepository.findAll();
    }

    @Override
    public Courses getCoursesById(int id) {
        return coursesRepository.findById(id);
    }

    @Override
    public void addCourses(Courses courses) {
        coursesRepository.addCourses(courses);
    }

    @Override
    public void updateCourses(Courses courses) {
        coursesRepository.update(courses);
    }

    @Override
    public void deleteCourses(int id) {
        coursesRepository.delete(id);
    }

}