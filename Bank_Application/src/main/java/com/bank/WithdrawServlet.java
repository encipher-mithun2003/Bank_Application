package com.bank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Withdraw
 */
@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accountNo = request.getParameter("accountNo");
		double amount = Double.parseDouble(request.getParameter("amount"));
	
		
		try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details","root","2003");
		
		PreparedStatement ps=con.prepareStatement("SELECT * from users WHERE accountNo=?");
		ps.setString(1, accountNo);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
		
		String sql = "UPDATE account SET balance=balance-? WHERE accountNo = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setDouble(1,amount);
		statement.setString(2,accountNo);
		statement.executeUpdate();
		
		ps=con.prepareStatement("SELECT balance FROM account WHERE accountNo=?");
		ps.setString(1, accountNo);
		rs = ps.executeQuery();
		String result="";
		
		if(rs.next()) {
			result = rs.getString("balance");
		}
		
		String description = "Withdraw";
		ps=con.prepareStatement("INSERT INTO transactions (accountNo,description,amount) VALUES (?,?,?)");
		ps.setString(1, accountNo);
		ps.setString(2, description);
		ps.setDouble(3, amount);
		ps.executeUpdate();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Withdraw.jsp?message= Amount Debited Successfully! \n<br>\n Your balance is :"+result);
	    dispatcher.forward(request, response);
		}
		else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Deposit.jsp?message= Enter the correct Account Number!");
		    dispatcher.forward(request, response);
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
  }
}
       
   