<%--
  Created by IntelliJ IDEA.
  User: mugabe
  Date: 2/26/25
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.mupro.mis.robust_mis.models.User" %>
<%@ page import="java.util.List" %>
<%@ page import="org.mupro.mis.robust_mis.models.Assignment" %>
<%@ page import="org.mupro.mis.robust_mis.dao.AssignmentDao" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
    User user = (User) session.getAttribute("user");
    if(user == null || user.getRole() != User.Role.INSTRUCTOR){
        response.sendRedirect("login.jsp");
        return;
    }
%>
<%
    User instructor = (User) session.getAttribute("user");
    AssignmentDao assignmentDao = new AssignmentDao();
    List<Assignment> assignments = assignmentDao.findByInstructor(instructor);
%>
<html>
<head>
    <title>Instructor dashboard</title>
</head>
<body>
<h2>Welcome, Instructor: <%= user.getFullName()%> !</h2>
<a href="logout">Logout</a>
<a href="create-assignment.jsp">Create new Assignment</a>

<h3>Your Assignments</h3>
<ul>
    <c:forEach var="assignment" items="${assignments}">
        <li>${assignment.title} -Deadline: ${assignment.deadline}</li>
    </c:forEach>
</ul>
</body>
</html>
