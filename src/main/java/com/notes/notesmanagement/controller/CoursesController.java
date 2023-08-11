package com.notes.notesmanagement.controller;

import java.util.List;

import com.notes.notesmanagement.model.Courses;
import com.notes.notesmanagement.service.CoursesService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CoursesController {
    
    private final CoursesService coursesService;

    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @GetMapping
    public List<Courses> getAllCourses() {
        return coursesService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Courses getCoursesById(@PathVariable int id) {
        return coursesService.getCoursesById(id);
    }

    @PostMapping
    public void addCourses(@RequestBody Courses courses) {
        coursesService.addCourses(courses);
    }

    @PutMapping("/{id}")
    public void updateCourses(@PathVariable int id, @RequestBody Courses courses) {
        courses.setId_course(id);
        coursesService.updateCourses(courses);
    }

    @DeleteMapping("/{id}")
    public void deleteCourses(@PathVariable int id) {
        coursesService.deleteCourses(id);
    }

}