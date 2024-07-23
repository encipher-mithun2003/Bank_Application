package com.bank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class removeUserServlet
 */
@WebServlet("/removeUserServlet")
public class removeUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accountNo = request.getParameter("accountNo");
		
		try {
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details","root","2003");
			PreparedStatement ps = con.prepareStatement("DELETE FROM account WHERE accountNo=?");
			ps.setString(1, accountNo);
			ps.executeUpdate();
			
			ps = con.prepareStatement("DELETE FROM users WHERE accountNo=?");
			ps.setString(1, accountNo);
			ps.executeUpdate();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/removeUser.jsp?message= The account "+accountNo+" removed Successfully!");
		    dispatcher.forward(request, response);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
