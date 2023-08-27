package com.notes.notesmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class Exams {
    private int id_exam;
    private int percentage;
    private int id_course;
    private double note;
}