package com.notes.notesmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Exams {
    private int id_exam;
    private int percentage;
    private int std;
    private int id_course;
}