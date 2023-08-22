package com.Resumebuilderapp;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.*;

import com.mysql.cj.xdevapi.SelectStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Form")
public class Resumeform extends HttpServlet{
	 
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//Database connection
			DatabaseConnections db=new DatabaseConnections();
			Connection con=db.getConnection();
			HttpSession session = req.getSession();
			User user=(User) new User();
			String email= (String) session.getAttribute("email");
			PrintWriter out= resp.getWriter();
	
				System.out.println("resume"+email);
				//Query to be executed
				String query="update users set name=?,email=?,phone=?,exp=?,education=?,summary=? where email=?";

				//prepared statement
				PreparedStatement psmt2=con.prepareStatement(query);
				
				//To retrive values form Jsp page
				psmt2.setString(1,req.getParameter("fullName"));
				psmt2.setString(2,email);
				psmt2.setString(3,req.getParameter("phone")); 
				psmt2.setString(4,req.getParameter("summary"));
				psmt2.setString(5,req.getParameter("experience"));
				psmt2.setString(6,req.getParameter("education"));
				psmt2.setString(7, email);
				int rowsUpdated = psmt2.executeUpdate();
				 if (rowsUpdated > 0) {
					 RequestDispatcher  rd=req.getRequestDispatcher("/userdata.jsp");
						resp.setContentType("text/html");
						out.print("<h3 style='color:green'> Your details are saved </h3>");

						//Includes the Above message to jsp page is this case "/userdata.jsp"
						rd.include(req, resp);

						psmt2.close();
				    } else {
				        out.print("No Data updated as data already present");
				    }	
			con.close();
		}catch(Exception e){
				System.out.println(e);
			}
		
	}
}
