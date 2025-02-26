<%--
  Created by IntelliJ IDEA.
  User: mugabe
  Date: 2/26/25
  Time: 9:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <script>
        function checkEmailExists() {
            var email = document.getElementById(email).value;
            fetch("check-email?email=" + email)
                .then(response => response.text())
                .then(data => {
                    if (data === "exists") {
                        alert("Email already exists");
                        event.preventDefault();
                    }
                });
        }

    </script>
</head>
<body>
<h2>Register</h2>
<form action="auth" method="post" onsubmit="checkEmailExists()">
    <input type="hidden" name="action" value="register">
    <label>Full Name</label>
    <input type="text" name="fullName" required>
    <br>
    <label>Email</label>
    <input type="email" id="email" name="email" required>
    <br>
    <label>Passoword</label>
    <input type="password" name="password" required>
    <br>
    <label>Role</label>
    <select name="role">
        <option value="STUDENT">Student</option>
        <option value="INSTRUCTOR">Instructor</option>
    </select>
    <br>
    <button type="submit">Register</button>
</form>
</body>
</html>
