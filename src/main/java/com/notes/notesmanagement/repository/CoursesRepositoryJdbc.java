package com.notes.notesmanagement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.notes.notesmanagement.connection.DatabaseConnection;
import com.notes.notesmanagement.model.Courses;

@Repository
public class CoursesRepositoryJdbc implements CoursesRepository {

    @Override
    public List<Courses> findAll() {
        List<Courses> courses = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Courses");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                courses.add(mapCourses(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public Courses findById(int id) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Courses WHERE id_course = ?");
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapCourses(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void addCourses(Courses courses) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Courses (course_name, credits) VALUES (?, ?)");

            preparedStatement.setString(1, courses.getCourse_name());
            preparedStatement.setInt(2, courses.getCredits());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Courses courses) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Courses SET course_name = ?, credits = ? WHERE id_course = ?");

            preparedStatement.setString(1, courses.getCourse_name());
            preparedStatement.setInt(2, courses.getCredits());
            preparedStatement.setInt(3, courses.getId_course());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Courses WHERE id_course = ?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Courses mapCourses(ResultSet resultSet) throws SQLException {
        return new Courses(
            resultSet.getInt("id_courses"), 
            resultSet.getString("course_name"),
            resultSet.getInt("credits")
        );
    }

}