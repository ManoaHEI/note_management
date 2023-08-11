package com.notes.notesmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Courses {
    private int id_course;
    private String course_name;
    private int credits;
}