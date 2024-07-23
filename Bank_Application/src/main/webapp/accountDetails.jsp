<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Details</title>
</head>
<body>

<form action="accountDetails" method="post">

<label for="accountNo">Account Number:</label>
<input name="accountNo" id="accountNo" type="number"/>
<button type="submit">Submit</button>

</form>

<%
String accountNum = (String)request.getAttribute("accountNo");
String username = (String)request.getAttribute("username");
String email = (String)request.getAttribute("email");
String contactNo = (String)request.getAttribute("contactNo");
String dob = (String)request.getAttribute("Dob");
String type = (String)request.getAttribute("TypeOfAccount");
String idProof = (String)request.getAttribute("AadharNo");
String balance = (String)request.getAttribute("balance");
    %>

<% if (accountNum != null) { %>
<h2>Account Details</h2>
<table border="1">
    <thead>
        <tr>
            <th>Account Number</th>
            <th>User Name</th>
            <th>Email</th>
            <th>Contact Number</th>
            <th>DOB</th>
            <th>Type of Account</th>
            <th>ID Proof</th>
            <th>Balance</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><%= accountNum != null ? accountNum : "" %></td>
            <td><%= username != null ? username : "" %></td>
            <td><%= email != null ? email : "" %></td>
            <td><%= contactNo != null ? contactNo : "" %></td>
            <td><%= dob != null ? dob : "" %></td>
            <td><%= type != null ? type : "" %></td>
            <td><%= idProof != null ? idProof : "" %></td>
            <td><%= balance != null ? balance : "" %></td>
        </tr>
    </tbody>
</table>
<% } %>

<%String message = request.getParameter("message");
if (message != null && !message.isEmpty()) { %>
    <p style="color: red;"><%= message %></p>
<% } %>

</body>
</html>