<%--
  Created by IntelliJ IDEA.
  User: mugabe
  Date: 2/26/25
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.mupro.mis.robust_mis.models.User" %>
<%
    User user = (User) request.getAttribute("user");
    if(user == null || user.getRole() != User.Role.INSTRUCTOR){
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Instructor dashboard</title>
</head>
<body>
<h2>Welcome, Instructor: <%= user.getFullName()%> !</h2>
<a href="logout">Logout</a>
</body>
</html>
