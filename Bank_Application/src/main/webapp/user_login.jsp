<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
<style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            width: 300px;
        }
        h2 {
            text-align: center;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label, input, button {
            margin-bottom: 10px;
        }
        input, button {
            padding: 10px;
            font-size: 16px;
        }
    </style>
</head>
<body>
	 <div class="container">
        <h2>User Login</h2>
        <form action=UserLoginServlet method="post">
            <label for="userUsername">Username:</label>
            <input type="text" id="userUsername" name="username" required>
            <label for="userPassword">Password:</label>
            <input type="password" id="userPassword" name="password" required>
            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>