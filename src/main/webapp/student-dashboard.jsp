<%--
  Created by IntelliJ IDEA.
  User: mugabe
  Date: 2/26/25
  Time: 9:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.mupro.mis.robust_mis.models.User" %>
<%@ page import="java.time.Year" %>

<%
  User user = (User) session.getAttribute("user");
  if(user == null || user.getRole() != User.Role.STUDENT){
    response.sendRedirect("login.jsp");
    return;
  }
%>
<html>
<head>
    <title>Student dashboard</title>
</head>
<body>
<h2>Welcome, Student: <%= user.getFullName()%> !</h2>
<a href="logout">Logout</a>
</body>
</html>
