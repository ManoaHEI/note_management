package com.notes.notesmanagement.repository;

import com.notes.notesmanagement.connection.DatabaseConnection;
import com.notes.notesmanagement.model.TakeExam;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TakeExamRepositoryJdbc implements TakeExamRepository {
    @Override
    public List<TakeExam> findAllExamNote() {
        List<TakeExam> takeExams = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();
            String sql = "SELECT (std , firstname , lastname , gender , level , note  , course_name) FROM student\n" +
                    "    INNER JOIN take_exams te on student.std = te.id_student\n" +
                    "   std INNER JOIN exams e on e.id_exams = te.id_exams\n" +
                    "    INNER JOIN courses c on c.id_course = e.id_course;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                takeExams.add(mapTakeExam(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return takeExams;
    }

    @Override
    public List<TakeExam> findExamNoteByIdStudent(int std) {
        List<TakeExam> takeExams = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();
            String sql = "SELECT (std , firstname , lastname , gender , level , note  , course_name) FROM student\n" +
                    "    INNER JOIN take_exams te on student.std = te.id_student\n" +
                    "    INNER JOIN exams e on e.id_exams = te.id_exams\n" +
                    "    INNER JOIN courses c on c.id_course = e.id_course\n" +
                    "    WHERE te.id_student = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, std);
                    
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                takeExams.add(mapTakeExam(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return takeExams;
    }

    @Override
    public List<TakeExam> findExamNoteByIdExam(int id) {
        List<TakeExam> takeExams = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();
            String sql = "SELECT (std , firstname , lastname , gender , level , note  , course_name) FROM student\n" +
                    "    INNER JOIN take_exams te on student.std = te.id_student\n" +
                    "    INNER JOIN exams e on e.id_exams = te.id_exams\n" +
                    "    INNER JOIN courses c on c.id_course = e.id_course\n" +
                    "    WHERE te.id_exams = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                takeExams.add(mapTakeExam(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return takeExams;
    }

    @Override
    public TakeExam findExamNoteById(int idStudent, int idExam) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String sql = "SELECT (std , firstname , lastname , gender , level , note  , course_name) FROM student\n" +
                    "    INNER JOIN take_exams te on student.std = te.id_student\n" +
                    "    INNER JOIN exams e on e.id_exams = te.id_exams\n" +
                    "    INNER JOIN courses c on c.id_course = e.id_course\n" +
                    "    WHERE te.id_student = ? AND te.id_exams = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, idStudent);
            preparedStatement.setInt(2 , idExam);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapTakeExam(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addTakeExam(TakeExam takeExam) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO take_exams VALUES (? , ? , ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1 , takeExam.getId_exam());
            preparedStatement.setInt(2 , takeExam.getId_student());
            preparedStatement.setDouble(3 , takeExam.getNote());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateByIdExam(TakeExam takeExam) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String sql = "UPDATE take_exams SET id_exams = ?, id_student = ?, note = ? WHERE id_exams = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1 , takeExam.getId_exam());
            preparedStatement.setInt(2 , takeExam.getId_student());
            preparedStatement.setDouble(3 , takeExam.getNote());
            preparedStatement.setInt(4 , takeExam.getId_exam());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateByIdStudent(TakeExam takeExam) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String sql = "UPDATE take_exams SET id_exams = ?, id_student = ?, note = ? WHERE id_student = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1 , takeExam.getId_exam());
            preparedStatement.setInt(2 , takeExam.getId_student());
            preparedStatement.setDouble(3 , takeExam.getNote());
            preparedStatement.setInt(4 , takeExam.getId_exam());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByIdStudent(int id) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM take_exams WHERE id_student = ?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByIdExam(int id) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM take_exams WHERE id_exams = ?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int idExam , int idStudent) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM take_exams WHERE id_exams = ? AND id_student = ?");

            preparedStatement.setInt(1, idExam);
            preparedStatement.setInt(2 , idStudent);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private TakeExam mapTakeExam(ResultSet resultSet) throws SQLException {
        return new TakeExam(
                resultSet.getInt("id_exam"),
                resultSet.getInt("id_student"),
                resultSet.getDouble("note")
        );
    }
}
