package com.notes.notesmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TakeExamExtended {
    private double note;
    private int std;
    private String firstname;
    private String lastname;
    private String gender;
    private String level;
    private String course_name;
}