<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body>

<center>

<h2>Customer Registration</h2>

</center>

<form action="addUserServlet" method="post">

<label for="username">User Name:</label>
<input name="username" id="username" type="text"/><br><br>

<label for="email">Email:</label>
<input name="email" id="email" type="text"/><br><br>

<label for="contactNo">Contact Number:</label>
<input name="contactNo" id="contactNo" type="text"><br><br>

<label for="address">Address:</label>
<input name="address" id="address" type="text"><br><br>

<label for="Dob">DOB:</label>
<input name="Dob" id="Dob" type="text"/><br><br>

<label for="TypeOfAccount">TypeOfAccount:</label>
<input name="TypeOfAccount" id="TypeOfAccount" type="text"/><br><br>

<label for="AadharNo">ID Proof:</label>
<input name="AadharNo" id="AadharNo" type="text"/><br><br>

<label for="amount">Initial Balance:</label>
<input name="amount" id="amount" type="number"/><br><br>

<button type="submit">Submit</button><br><br>

</form>

<%
String message=request.getParameter("message");

String username = request.getParameter("username");
String password = request.getParameter("password");

if (message != null && !message.isEmpty()) { %>
    <p style="color: green;"><%= message %></p>
<% } %>

<%= username!=null? "Your Username is "+ username:""%>
<%= password!=null? "Your Tempoprary password is "+ password:""%>

<button onclick="window.location.href='admin_home.jsp'">Go back</button>


</body>
</html>