<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remove User</title>
</head>
<body>
<form action="removeUserServlet" method="post">

<label for="accountNo">Account Number:</label>
<input name="accountNo" id="accountNo" type="text"/>

<button type="submit">Submit</button><br>

<%
String message=request.getParameter("message");
if (message != null && !message.isEmpty()) { %>
    <p style="color: green;"><%= message %></p>
<% } %>

<button onclick="window.location.href='admin_home.jsp'">Go Back</button>
</form>
</body>
</html>