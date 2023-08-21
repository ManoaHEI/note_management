package com.notes.notesmanagement.service;

import com.notes.notesmanagement.model.Courses;
import com.notes.notesmanagement.repository.CoursesRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Service;

import java.util.List;

@Service
=======

import java.util.List;

>>>>>>> 906da8a4a076c07108be5d177ed9bf1ec5a14db9
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

<<<<<<< HEAD
}
=======
}
>>>>>>> 906da8a4a076c07108be5d177ed9bf1ec5a14db9
