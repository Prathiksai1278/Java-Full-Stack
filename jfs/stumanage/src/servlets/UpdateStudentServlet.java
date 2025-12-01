package servlets;

import beans.Student;
import dao.StudentDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

//@WebServlet("/update")
public class UpdateStudentServlet extends HttpServlet {
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
            boolean ok = dao.updateStudent(s);
            resp.setContentType("text/html");
            if (ok) resp.getWriter().println("<p>Updated successfully.</p><a href='view'>View Students</a>");
            else resp.getWriter().println("<p>Update failed.</p><a href='view'>View Students</a>");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    // if user opens update.html with rollno param, we could prefill via simple form (handled by update.html + small JS)
}
