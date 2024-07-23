package com.bank;

import java.io.IOException;
import java.util.Random;
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
 * Servlet implementation class addUserServlet
 */
@WebServlet("/addUserServlet")
public class addUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String contactNo = request.getParameter("contactNo");
		String address = request.getParameter("address");
		String dob = request.getParameter("Dob");
		String type = request.getParameter("TypeOfAccount");
		String idProof = request.getParameter("AadharNo");
		String amount = request.getParameter("amount");
		
		Random random = new Random();
		String password = random.nextInt(10000)+"";
		
		try {
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details","root","2003");
			PreparedStatement ps = con.prepareStatement("INSERT INTO account (username,email,contactNo,address,Dob,TypeOfAccount,AadharNo,balance)  VALUES (?,?,?,?,?,?,?,?)");
			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3, contactNo);
			ps.setString(4, address);
			ps.setString(5, dob);
			ps.setString(6,type);
			ps.setString(7, idProof);
			ps.setString(8,amount);
			ps.executeUpdate();
			
			ps=con.prepareStatement("SELECT accountNo FROM account WHERE contactNo=?");
			ps.setString(1, contactNo);
			ResultSet rs = ps.executeQuery();
			
			String accountNo="";
			if(rs.next()) {
			accountNo = rs.getString("accountNo");
			}
			
			
			ps=con.prepareStatement("INSERT INTO users (username,password,accountNo) VALUES (?,?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3,accountNo);
			ps.executeUpdate();
			
			
			
			request.setAttribute("password",password);
			request.setAttribute("username",username);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/addUser.jsp?message= The account "+accountNo+" Added Successfully! \n<br>\n Your temporary password is "+password);
		    dispatcher.forward(request, response);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

}
}