<%@page import="com.Resumebuilderapp.DatabaseConnections"%>
<%@ page  import ="java.sql.*"%>
<%@ page import ="jakarta.servlet.http.HttpSession"%>
<%@ page  import ="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Connection con=null;
	DatabaseConnections db=new DatabaseConnections();
	String email=(String)session.getAttribute("email");
	String driver="com.mysql.cj.jdbc.Driver";
	System.out.println("userdata"+email);
	String query="select * from users where email=?";
	
	con=db.getConnection();
	Class.forName(driver);
	
	PreparedStatement psmt=con.prepareStatement(query);
	psmt.setString(1,email);
	ResultSet result= psmt.executeQuery();
	while(result.next()){

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="stylesdata.css">
    <title>Resume Display</title>
</head>
<body>
    <div class="container">
        <h1>Resume Display</h1>
        <div id="resumeData">
            <h2>Personal Information</h2>
            <p><strong>Name:</strong><%=result.getString("name")%></p>
            <p><strong>Email:</strong><%=result.getString("email") %></p>
            <p><strong>Phone:</strong><%=result.getLong("phone") %></p>
            
            <h2>Summary</h2>
            <p><%=result.getString("summary") %></p>
            
            <h2>Experience</h2>
            <p><%=result.getString("exp") %></p>
            
            <h2>Education</h2>
            <p><%=result.getString("education") %></p>
        </div>
        <% 
			}
			con.close();
			psmt.close();
        %>
        
         <div class="download-button">
            <a href="download_resume.jsp" download="resume.txt">Download Resume</a>
        </div>
    </div>
</body>
</html>
