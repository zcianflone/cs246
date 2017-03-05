<%-- 
    Document   : index
    Created on : Mar 3, 2017, 5:17:54 PM
    Author     : zaccianflone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
             <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Discussion Forum Login</title>
    </head>
    <body>
        <h3>Login Here</h3>
        <hr/>
        <form method="post" action="SignIn">
            <label for="Username">Username:</label>
            <input type="text" id="Username" name="Username"></input>
            <br/>
            <label for="Password">Password:</label>
            <input type="password" id="Password" name="Password"></input>
            <br/>
           <input type="submit" class="btn btn-info" value="Login">
        </form>
    </body>
</html>
