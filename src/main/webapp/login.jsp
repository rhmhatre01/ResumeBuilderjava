<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <link rel="stylesheet" type="text/css" href="logincss.css">
</head>
<body>
  <div class="login-container">
    <h2>Login</h2>
    <form action="login" method="post">
      <div class="input-container">
        <input class="login-input" type="email" name="email" placeholder="Email" required>
      </div>
      <div class="input-container">
        <input class="login-input" type="password" name="password" placeholder="Password" required>
      </div>
      <p style="color: red" id="message"></p>
      <button class="login-button" type="submit">Log In</button>
      <%
    String errorMessage = (String) request.getAttribute("message");
    if (errorMessage != null && !errorMessage.isEmpty()) {
%>
    <div class="error-message">
        <%= errorMessage %>
    </div>
<%
    }
%>
    </form>
  </div>
</body>
</html>

