/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aayush.web.dao.impl;

import com.aayush.web.dao.StudentDAO;
import com.aayush.web.entity.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dell
 */
@Repository(value = "StudentDAOImpl")
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> getAll() {
        String sql = "Select * from students";
        return jdbcTemplate.query(sql, new RowMapper<Student>() {

            @Override
            public Student mapRow(ResultSet rs, int i) throws SQLException {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setFirst_name(rs.getString("first_name"));
                student.setMiddle_name(rs.getString("middle_name"));
                student.setLast_name(rs.getString("last_name"));
                student.setContact_no(rs.getString("contact_no"));
                student.setEmail(rs.getString("email"));
                student.setStatus(rs.getBoolean("status"));
                return student;
            }

        });
    }

    @Override
    public Student getById(int id) {
        String sql = "Select * from students where id=?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id}, new RowMapper<Student>() {

            @Override
            public Student mapRow(ResultSet rs, int i) throws SQLException {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setFirst_name(rs.getString("first_name"));
                student.setMiddle_name(rs.getString("middle_name"));
                student.setLast_name(rs.getString("last_name"));
                student.setContact_no(rs.getString("contact_no"));
                student.setEmail(rs.getString("email"));
                student.setStatus(rs.getBoolean("status"));
                return student;
            }

        });
        
    }

    @Override
    public int insert(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
