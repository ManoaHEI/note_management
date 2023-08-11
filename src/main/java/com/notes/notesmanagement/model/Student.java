package com.notes.notesmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    private int std;
    private String firstname;
    private String lastname;
    private String gender;
    private String level;
}