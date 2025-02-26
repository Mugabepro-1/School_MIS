<%--
  Created by IntelliJ IDEA.
  User: mugabe
  Date: 2/26/25
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create assignment</title>
</head>
<body>
<form action="CreateAssignment" method="post">
    <label>Title</label>
    <input type="text" id="title" name = "title" required>
    <label>Description</label>
    <textarea id="description" name="description"></textarea>
    <label>Deadline</label>
    <input type="datetime-local" id="deadline" name="deadline">
    <button type="submit">Create Assignment</button>
</form>
</body>
</html>
