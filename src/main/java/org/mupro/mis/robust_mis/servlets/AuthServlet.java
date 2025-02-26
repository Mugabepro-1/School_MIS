package org.mupro.mis.robust_mis.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mupro.mis.robust_mis.dao.UserDao;
import org.mupro.mis.robust_mis.models.User;

import java.io.IOException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if("register".equals(action)){
            registerUser(request, response);
        }else if("login".equals(action)){
            loginUser(request, response);
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String email = request.getParameter(("email"));
        String password = request.getParameter("password");
        String roleParam = request.getParameter("role");

        if(userDao.findByEmail(email) != null){
            request.setAttribute("error", "Email already exists!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        User.Role role = "INSTRUCTOR".equalsIgnoreCase(roleParam) ? User.Role.INSTRUCTOR : User.Role.STUDENT;
        User newUser = new User(fullName, email, password, role);
        userDao.save(newUser);

        response.sendRedirect("login.jsp?success=1");
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userDao.findByEmail(email);
        if(user != null && user.getPassword().equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            if(user.getRole().equals(User.Role.INSTRUCTOR)){
                response.sendRedirect("instructor-dashboard.jsp");
            }else{
                response.sendRedirect("student-dashboard.jsp");
            }
        }else{
            request.setAttribute("error", "Invalid credentials");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
//In this project I just stopped where there was an error where the instructor is
//created and inserted to the database but not able to log in so see you next tome.