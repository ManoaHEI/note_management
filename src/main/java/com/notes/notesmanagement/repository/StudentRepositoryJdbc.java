package com.notes.notesmanagement.repository;

import com.notes.notesmanagement.connection.DatabaseConnection;
import com.notes.notesmanagement.model.Student;
/*import org.springframework.beans.factory.annotation.Autowired;*/
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryJdbc implements StudentRepository {
/*
    private final DatabaseConnection databaseConnection;

    @Autowired
    public StudentRepositoryJdbc(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
*/
    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Student");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                students.add(mapStudent(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Student findById(int id) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Student WHERE std = ?");
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapStudent(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addStudent(Student student) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Student (std, firstname, lastname, gender, level) VALUES (?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, student.getStd());
            preparedStatement.setString(2, student.getFirstname());
            preparedStatement.setString(3, student.getLastname());
            preparedStatement.setString(4, student.getGender());
            preparedStatement.setString(5, student.getLevel());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Student SET firstname = ?, lastname = ?, gender = ?, level = ? WHERE std = ?");

            preparedStatement.setString(1, student.getFirstname());
            preparedStatement.setString(2, student.getLastname());
            preparedStatement.setString(3, student.getGender());
            preparedStatement.setString(4, student.getLevel());
            preparedStatement.setInt(5, student.getStd());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Student WHERE std = ?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Student mapStudent(ResultSet resultSet) throws SQLException {
        return new Student(
            resultSet.getInt("std"),
            resultSet.getString("firstname"),
            resultSet.getString("lastname"),
            resultSet.getString("gender"),
            resultSet.getString("level")
        );
    }
}