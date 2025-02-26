package org.mupro.mis.robust_mis.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mupro.mis.robust_mis.dao.UserDao;

import java.io.IOException;

@WebServlet("/check-email")
public class CheckEmailServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        boolean exists = userDao.findByEmail(email) != null;
        response.getWriter().write(exists ? "exists" : "available");
    }
}
