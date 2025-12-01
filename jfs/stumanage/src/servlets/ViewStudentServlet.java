package servlets;

import dao.StudentDAOImpl;
import beans.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

//@WebServlet("/view")
public class ViewStudentServlet extends HttpServlet {
    private StudentDAOImpl dao = new StudentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Student> list = dao.getAllStudents();
            resp.setContentType("text/html");
            StringBuilder sb = new StringBuilder();
            sb.append("<h2>All Students</h2>");
            sb.append("<table border='1' cellpadding='5'><tr><th>Roll</th><th>Name</th><th>Age</th><th>Gender</th><th>Email</th><th>Actions</th></tr>");
            for (Student s : list) {
                sb.append("<tr>")
                  .append("<td>"+s.getRollno()+"</td>")
                  .append("<td>"+s.getName()+"</td>")
                  .append("<td>"+s.getAge()+"</td>")
                  .append("<td>"+s.getGender()+"</td>")
                  .append("<td>"+s.getEmail()+"</td>")
                  .append("<td><a href='update.html?rollno="+s.getRollno()+"'>Edit</a> | <a href='delete.html?rollno="+s.getRollno()+"'>Delete</a></td>")
                  .append("</tr>");
            }
            sb.append("</table><br><a href='index.html'>Home</a>");
            resp.getWriter().println(sb.toString());
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
