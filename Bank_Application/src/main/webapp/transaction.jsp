<%@ page language="java" import ="java.util.*"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction Details</title>
</head>
<body>

<form action="TransactionServlet" method="post">

<label for="accountNo">Account Number:</label>
<input name="accountNo" idd="accountNo" type="text"/>

<button type="submit">Submit</button>

</form>
 <%
        List<Object[]> transactions = (List<Object[]>) request.getAttribute("transactions");
        if (transactions != null && !transactions.isEmpty()) {
    %>

    <h2>Transaction List</h2>
    <table border="1">
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Amount</th>
        </tr>
        <% for (Object[] transaction : transactions) { %>
        <tr>
            <td><%= transaction[0] %></td>
            <td><%= transaction[1] %></td>
            <td><%= transaction[2] %></td>
        </tr>
        <% } %>
    </table>
    <%
        } else if (transactions != null && transactions.isEmpty()) {
    %>
    <p>No transactions found.</p>
    <%
        }
    %>

<br><br>

<button onclick="window.location.href='user_home.jsp'">Go Back</button>
</body>
</html>