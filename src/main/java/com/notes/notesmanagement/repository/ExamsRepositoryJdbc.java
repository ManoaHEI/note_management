package com.notes.notesmanagement.repository;

import com.notes.notesmanagement.connection.DatabaseConnection;
import com.notes.notesmanagement.model.Exams;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ExamsRepositoryJdbc implements ExamsRepository {

    @Override
    public List<Exams> findAll() {
        List<Exams> exams = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Exams");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                exams.add(mapExams(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exams;
    }

    @Override
    public Exams findById(int id) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Exams WHERE id_exams = ?");
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapExams(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addExams(Exams exams) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Exams (percentage, std, id_course, note) VALUES (?, ?, ?, ?)");

            preparedStatement.setInt(1, exams.getPercentage());
            preparedStatement.setInt(2, exams.getStd());
            preparedStatement.setInt(3, exams.getId_course());
            preparedStatement.setDouble(4, exams.getNote());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Exams exams) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Exams SET percentage = ? WHERE id_exam = ?");

            preparedStatement.setInt(1,exams.getPercentage());
            preparedStatement.setInt(2,exams.getId_exam());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Exams WHERE id_exam = ?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Exams mapExams(ResultSet resultSet) throws SQLException {
        return new Exams(
                resultSet.getInt("id_exam"),
                resultSet.getInt("percentage"),
                resultSet.getInt("std"),
                resultSet.getInt("id_course"),
                resultSet.getInt("note")
        );
    }
}