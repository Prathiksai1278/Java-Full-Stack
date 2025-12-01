package servlets;

import dao.StudentDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

//@WebServlet("/delete")
public class DeleteStudentServlet extends HttpServlet {
    private StudentDAOImpl dao = new StudentDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int roll = Integer.parseInt(req.getParameter("rollno"));
            boolean ok = dao.deleteStudent(roll);
            resp.setContentType("text/html");
            if (ok) resp.getWriter().println("<p>Deleted successfully.</p><a href='view'>View Students</a>");
            else resp.getWriter().println("<p>Delete failed.</p><a href='view'>View Students</a>");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
