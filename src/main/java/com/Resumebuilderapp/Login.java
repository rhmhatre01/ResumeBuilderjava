package com.Resumebuilderapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import com.mysql.cj.protocol.Resultset;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DatabaseConnections db=new DatabaseConnections();
		Connection con=db.getConnection();
		PrintWriter out=resp.getWriter();
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String query="select * from users where email = ? and password = ?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				User Loggeduser=new User();
				Loggeduser.setUsername(rs.getString("email"));
				HttpSession session = req.getSession();
				session.setAttribute("email",email);
				resp.sendRedirect("Form.jsp");
			}else {
				System.out.println("good");
				RequestDispatcher rq = req.getRequestDispatcher("/login.jsp");
				resp.setContentType("text/html");

				String errorMessage = "<p style='color: red;'>Incorrect Email or password</p>";

				req.setAttribute("message", errorMessage);

				rq.forward(req, resp);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
