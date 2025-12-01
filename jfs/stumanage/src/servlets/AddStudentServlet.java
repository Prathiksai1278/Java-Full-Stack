package servlets;

import beans.Student;
import dao.StudentDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

//@WebServlet("/add")
public class AddStudentServlet extends HttpServlet {
    private StudentDAOImpl dao = new StudentDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int roll = Integer.parseInt(req.getParameter("rollno"));
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            String gender = req.getParameter("gender");
            String email = req.getParameter("email");

            Student s = new Student(roll, name, age, gender, email);
            boolean ok = dao.addStudent(s);
            resp.setContentType("text/html");
            if (ok) {
                resp.getWriter().println("<p>Student added successfully.</p><a href='index.html'>Home</a>");
            } else {
                resp.getWriter().println("<p>Failed to add student.</p><a href='index.html'>Home</a>");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
