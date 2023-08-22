<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Sign Up Form</title>
  <link rel="stylesheet" type="text/css" href="Signupcss.css">
</head>
<body>
  <div class="signup-container">
    <h2>Sign Up</h2>
    <form action="Signup" method="post">
      <input class="signup-input" type="text" name="fullName" placeholder="Full Name" required>
      <input class="signup-input" type="email" name="email" placeholder="Email" required>
      <input class="signup-input" type="password" name="password" placeholder="Password" required>
      <button class="signup-button" type="submit">Sign Up</button>
    </form>
  </div>
</body>
</html>
