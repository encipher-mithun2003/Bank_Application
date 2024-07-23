package com.bank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class changePass
 */
@WebServlet("/changePass")
public class changePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accountNo = request.getParameter("accountNo");
		String currentPass = request.getParameter("currentPass");
		String newPass = request.getParameter("newPass");
		
		try {
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details","root","2003");
			
			PreparedStatement ps=con.prepareStatement("SELECT password from users WHERE accountNo=?");
			ps.setString(1, accountNo);
			ResultSet rs= ps.executeQuery();
			String result ="";
			if(rs.next()) {
			result = rs.getString("password");
			}
			
			if(result.equals(currentPass)) {
			
			
			ps = con.prepareStatement("UPDATE users SET password=? WHERE password=? AND accountNo=?");
			ps.setString(1, newPass);
			ps.setString(2, currentPass); 
			ps.setString(3, accountNo);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/changePass.jsp?message= Your Password changed Succesfully!");
		    dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/changePass.jsp?message= Check the Details You Entered!");
			    dispatcher.forward(request, response);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
