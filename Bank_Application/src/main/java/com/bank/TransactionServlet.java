package com.bank;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accountNo = request.getParameter("accountNo");
		
		try {
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details","root","2003");
			PreparedStatement ps = con.prepareStatement("SELECT date,description,amount FROM transactions WHERE accountNo=?");
			ps.setString(1, accountNo);
			ResultSet rs = ps.executeQuery();
			
			List<Object[]> transactionList = new ArrayList<>();
			
			while (rs.next()) {
                Timestamp date = rs.getTimestamp("date");
                String description = rs.getString("description");
                double amount = rs.getDouble("amount");
                Object[] transaction = {date, description, amount};
                transactionList.add(transaction);
			}
			
			request.setAttribute("transactions", transactionList);
	        request.getRequestDispatcher("transaction.jsp").forward(request, response);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
