<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Withdraw</title>
</head>
<body>
 
<% String message = request.getParameter("message"); %>

<form action=WithdrawServlet method="post">

<label for="accountNo" >Account Number:</label>
<input name="accountNo" id="accountNo" type="text"/>

<label for="amount" >Enter Amount:</label>
<input name="amount" id="amount" type="number"/>

<button type="submit">Submit</button>

</form>
 
<% if (message != null && !message.isEmpty()) { %>
    <p style="color: green;"><%= message %></p>
<% } %>
<button class="User Home" onclick="window.location.href='user_home.jsp'">Go Back</button>
</body>
</html>