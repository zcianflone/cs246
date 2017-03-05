<%-- 
    Document   : viewPosts
    Created on : Mar 3, 2017, 11:44:04 PM
    Author     : zaccianflone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <title>View Posts</title>
    </head>
    <body>
        <h3>Posts!</h3>
        <hr/>
        <ul class="list-group">
            <c:forEach var="post" items="${posts}">
                <li class="list-group-item">${post.postText} <br/><br/> by <strong>${post.username}</strong> @${post.postTime}<br/></li>
            </c:forEach>
        </ul>
        
        
       <a href="newPost.jsp" class="btn btn-info" role="button">Add New Post</a>
       <br/>
       <br/>
    </body>
</html>



 
