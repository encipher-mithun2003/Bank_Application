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
 * Servlet implementation class accountDetails
 */
@WebServlet("/accountDetails")
public class accountDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accountNo = request.getParameter("accountNo");		
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details","root","2003");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM account WHERE accountNo=?");
			ps.setString(1,accountNo);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
                // Retrieve data from ResultSet
                String accountNum = rs.getInt("accountNo")+"";
                String userName = rs.getString("username");
                String email = rs.getString("email");
                String contactNo = rs.getString("contactNo");
                String dob = rs.getString("Dob");
                String type = rs.getString("TypeOfAccount");
                String idProof = rs.getString("AadharNo");
                String balance = rs.getDouble("balance")+"";

                // Set attributes for forwarding to JSP
                request.setAttribute("accountNo", accountNum);
                request.setAttribute("username", userName);
                request.setAttribute("email", email);
                request.setAttribute("contactNo", contactNo);
                request.setAttribute("Dob", dob);
                request.setAttribute("TypeOfAccount", type);
                request.setAttribute("AadharNo", idProof);
                request.setAttribute("balance", balance);

                // Forward request to JSP for displaying account details
                RequestDispatcher dispatcher = request.getRequestDispatcher("/accountDetails.jsp");
                dispatcher.forward(request, response);
			}
			
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/accountDetails.jsp?message= Enter the correct Account Number!");
                dispatcher.forward(request, response);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
