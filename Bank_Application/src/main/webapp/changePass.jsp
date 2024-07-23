<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
</head>
<body>

<form action="changePass" method="post">

<label for="accountNo">Account Number:</label>
<input name="accountNo" id="accountNo" type="text"/>

<label for="currentPass">Current Password:</label>
<input name="currentPass" id="currentPass" type="text"/>

<label for="newPass">New Password:</label>
<input name="newPass" id="newPass" type="text"/>

<button type="submit">Submit</button>

</form>

<%String message = request.getParameter("message");
if (message != null && !message.isEmpty()) { %>
    <p style="color: green;"><%= message %></p>
<% } %>



<button onclick="window.location.href='user_home.jsp'">Go back</button>


</body>
</html>