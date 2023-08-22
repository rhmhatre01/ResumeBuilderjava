
<%@page import="com.Resumebuilderapp.DatabaseConnections"%>
<%@ page  import ="java.sql.*"%>
<%@ page  import ="com.Resumebuilderapp.*"%>
<%@ page  import ="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String email= (String) session.getAttribute("email");
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>Create your Account</title>
</head>
<body>
	 <div class="container">
        <h1>Resume Builder</h1>
        <form action="Form" method="post">
            <label for="fullName">Full Name:</label>
            <input type="text" id="fullName" name="fullName" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name=email required><%=email %>

            <label for="phone">Phone:</label>
            <input type="tel" id="phone" name="phone" required>

            <label for="summary">Summary:</label>
            <textarea id="summary" name="summary" rows="4" required></textarea>

            <label for="experience">Experience:</label>
            <textarea id="experience" name="experience" rows="6" required></textarea>

            <label for="education">Education:</label>
            <textarea id="education" name="education" rows="4" required></textarea>

            <button type="submit" name="submit">Generate Resume</button>
        </form>
    </div>

</body>
</html>