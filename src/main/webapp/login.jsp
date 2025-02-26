<%--
  Created by IntelliJ IDEA.
  User: mugabe
  Date: 2/26/25
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<% if (request.getParameter("success") != null){ %>
<p style="color: green;">Registration successful please login!</p>
<% } %>

<form action="auth" method="post">
    <input type="hidden" name="action" value="login">
    <label>Email</label>
    <input type="email" name="email" required>
    <br>
    <label>Password</label>
    <input type="password" name="password" required>
    <br>
    <button type="submit">Login</button>
</form>
<% if(request.getAttribute("error") != null){%>
<p style="color: red"><%= request.getAttribute("error") %></p>
<% } %>
</body>
</html>
