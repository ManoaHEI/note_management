package com.notes.notesmanagement.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;
import org.springframework.stereotype.Repository;

import com.notes.notesmanagement.model.Courses;
import com.notes.notesmanagement.model.Student;

@Repository
public class CoursesRepositoryJdbc implements CoursesRepository {
    
    private final DataSource dataSource;

    @Autowired
    public CoursesRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Courses> findAll() {
        List<Student> students = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.preparedStatement("SELECT * FROM Student");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                students.add(mapStudent(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}