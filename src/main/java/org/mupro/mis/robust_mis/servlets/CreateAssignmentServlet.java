package org.mupro.mis.robust_mis.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mupro.mis.robust_mis.dao.AssignmentDao;
import org.mupro.mis.robust_mis.models.Assignment;
import org.mupro.mis.robust_mis.models.User;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;

@WebServlet("/CreateAssignment")
public class CreateAssignmentServlet extends HttpServlet {

    private final AssignmentDao assignmentDao = new AssignmentDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String deadlineStr = request.getParameter("deadline");

        Timestamp deadline = Timestamp.valueOf(deadlineStr);

        HttpSession session = request.getSession();
        User instructor = (User) session.getAttribute("user");

        if(instructor == null){
            response.sendRedirect("login.jsp?error=not_logged_in");
            return;
        }
        Assignment assignment = new Assignment(title, description, deadline, instructor);
        assignmentDao.save(assignment);

        response.sendRedirect("instructor-dashboard.jsp?success=1");
    }

}
