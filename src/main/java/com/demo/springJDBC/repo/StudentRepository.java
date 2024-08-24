package com.demo.springJDBC.repo;

import com.demo.springJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s) {
       // System.out.println("Added");
        String sql = " insert into student (id, name, marks) values(?, ? ,?)";

        int rows = jdbc.update(sql, s.getId(), s.getName(), s.getMarks());
        System.out.println("Effected rows : "+rows);
    }

    public List<Student> findAll() {
//        List<Student> students = new ArrayList<>();
//        return students;
        String sql = "select * from student";

        RowMapper<Student> rowMapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));

                return s;
            }
        };

        return jdbc.query(sql, rowMapper);

    }
}
