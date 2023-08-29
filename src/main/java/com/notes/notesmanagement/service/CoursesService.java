package com.notes.notesmanagement.service;

import java.util.List;
import com.notes.notesmanagement.model.Courses;

public interface CoursesService {
    List<Courses> getAllCourses();
    Courses getCoursesById(int id);
    void addCourses(String course_name , int credits);
    void updateCourses(Courses courses);
    void deleteCourses(int id);
}