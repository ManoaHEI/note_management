package com.notes.notesmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Courses {
    private int id_course;
    private String course_name;
    private int credits;
}