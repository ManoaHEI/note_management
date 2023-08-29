package com.notes.notesmanagement.repository;

import java.util.List;

import com.notes.notesmanagement.model.Courses;

public interface CoursesRepository {
    List<Courses> findAll();
    Courses findById(int id);
    void addCourses(String course_name , int credits);
    void update(Courses courses);
    void delete(int id);
}