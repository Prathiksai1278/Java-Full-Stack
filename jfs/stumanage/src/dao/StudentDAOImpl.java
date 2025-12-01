package dao;

import beans.Student;
import factory.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private Connection conn() throws Exception {
        return DBConnection.getConnection();
    }

    @Override
    public boolean addStudent(Student s) throws Exception {
        String sql = "INSERT INTO students (rollno,name,age,gender,email) VALUES (?,?,?,?,?)";
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, s.getRollno());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getAge());
            ps.setString(4, s.getGender());
            ps.setString(5, s.getEmail());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean updateStudent(Student s) throws Exception {
        String sql = "UPDATE students SET name=?, age=?, gender=?, email=? WHERE rollno=?";
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getGender());
            ps.setString(4, s.getEmail());
            ps.setInt(5, s.getRollno());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean deleteStudent(int rollno) throws Exception {
        String sql = "DELETE FROM students WHERE rollno=?";
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, rollno);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Student getStudent(int rollno) throws Exception {
        String sql = "SELECT * FROM students WHERE rollno=?";
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, rollno);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                        rs.getInt("rollno"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("email")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() throws Exception {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection c = conn(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Student(
                    rs.getInt("rollno"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("gender"),
                    rs.getString("email")
                ));
            }
        }
        return list;
    }
}
