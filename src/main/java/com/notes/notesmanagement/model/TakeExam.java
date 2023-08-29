package com.notes.notesmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TakeExam {
    private int id_exam;
    private int id_student;
    private double note;
}