package com.bank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
/*import javax.servlet.ServletContext;*/
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BalanceServlet
 */
@WebServlet("/BalanceServlet")
public class BalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int accountNo = Integer.parseInt(request.getParameter("accountNo"));
	String accountNo=request.getParameter("accountNo");
		
		try {
			
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details","root","2003");
		
		PreparedStatement ps=con.prepareStatement("SELECT * from users WHERE accountNo=?");
		ps.setString(1, accountNo);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			
		
		String sql = "SELECT balance FROM account WHERE accountNo =?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1,accountNo);
		rs = statement.executeQuery();
		double balance=0.0;
		if(rs.next()) {
			 balance = rs.getDouble("balance");
			request.setAttribute("balance",balance);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Balance.jsp?message= Your current balance is :"+balance);
	    dispatcher.forward(request, response);
		
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Balance.jsp?message= Enter the Correct Account Number!");
		    dispatcher.forward(request, response);
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
