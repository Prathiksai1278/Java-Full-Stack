package dao;

import beans.Student;
import java.util.List;

public interface StudentDAO {
    boolean addStudent(Student s) throws Exception;
    boolean updateStudent(Student s) throws Exception;
    boolean deleteStudent(int rollno) throws Exception;
    Student getStudent(int rollno) throws Exception;
    List<Student> getAllStudents() throws Exception;
}
