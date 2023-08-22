package com.Resumebuilderapp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.Resumebuilderapp.DatabaseConnections;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Signup")
public class SignUpServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out=resp.getWriter();
	DatabaseConnections db=new DatabaseConnections();
	Connection con=DatabaseConnections.getConnection();
	//System.out.println(con);
	//get values from signup
	String query="insert into users (name,email,password) values(?,?,?)";
	String name=req.getParameter("fullName");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	//prepared Statment
	try {
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,name);
    	ps.setString(2,email);
    	ps.setString(3,password);
    	ps.executeUpdate();
    	
    	//to send to login page
    	RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
    	resp.setContentType("text/html");
    	out.print("<body style=\"font-family: Arial, sans-serif; background-color: #f5f5f5; margin: 0; display: flex; justify-content: center; align-items: center; min-height: 100vh;\">\r\n"
    			+ "\r\n"
    			+ "<div style=\"background-color: #fff; border-radius: 10px; box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2); padding: 40px; text-align: center; transform: translateY(0); opacity: 1; transition: transform 0.3s ease, opacity 0.3s ease;\">\r\n"
    			+ "  <h2 style=\"color: #333; margin-bottom: 20px; animation: fadeInDown 1s ease;\">Signup Successful</h2>\r\n"
    			+ "  <p style=\"color: #666; margin-bottom: 30px; animation: fadeInUp 1s ease;\">You have successfully Signed up press continue to login to your account.</p>\r\n"
    			+ "  <a href=\"login.jsp\" style=\"background-color: #007bff; color: #fff; border: none; border-radius: 6px; padding: 10px 20px; font-size: 16px; text-decoration: none; transition: background-color 0.3s ease; animation: fadeInUp 1s ease;\">Continue</a>\r\n"
    			+ "</div>\r\n"
    			+ "\r\n"
    			+ "<style>\r\n"
    			+ "  @keyframes fadeInUp {\r\n"
    			+ "    from {\r\n"
    			+ "      opacity: 0;\r\n"
    			+ "      transform: translateY(20px);\r\n"
    			+ "    }\r\n"
    			+ "    to {\r\n"
    			+ "      opacity: 1;\r\n"
    			+ "      transform: translateY(0);\r\n"
    			+ "    }\r\n"
    			+ "  }\r\n"
    			+ "\r\n"
    			+ "  @keyframes fadeInDown {\r\n"
    			+ "    from {\r\n"
    			+ "      opacity: 0;\r\n"
    			+ "      transform: translateY(-20px);\r\n"
    			+ "    }\r\n"
    			+ "    to {\r\n"
    			+ "      opacity: 1;\r\n"
    			+ "      transform: translateY(0);\r\n"
    			+ "    }\r\n"
    			+ "  }\r\n"
    			+ "</style>\r\n"
    			+ "\r\n"
    			+ "</body>");
    	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
