package com.notes.notesmanagement.repository;

import com.notes.notesmanagement.model.Student;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepositoryJdbc implements StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> findAll() {
        String sql = "SELECT * FROM Student";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    @Override
    public Student findById(Integer id) {
        String sql = "SELECT * FROM Student WHERE std = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new StudentRowMapper());
    }

    @Override
    public void addStudent(Student student) {
        String sql = "INSERT INTO Student (std, firstname, lastname, gender, level) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, student.getStd(), student.getFirstname(), student.getLastname(), student.getGender(), student.getLevel());
    }

    @Override
    public void update(Student student) {
        String sql = "UPDATE Student SET firstname = ?, lastname = ?, gender = ?, level = ? WHERE std = ?";
        jdbcTemplate.update(sql, student.getFirstname(), student.getLastname(), student.getGender(), student.getLevel(), student.getStd());
    }

    @Override
    public void delete(Integer std) {
        String sql = "DELETE FROM Student WHERE std = ?";
        jdbcTemplate.update(sql, std);
    }

    private static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Student(rs.getInt("std"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("gender"), rs.getString("level"));
        }
    }
}