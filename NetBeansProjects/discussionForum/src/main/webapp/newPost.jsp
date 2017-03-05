<%-- 
    Document   : newPost
    Created on : Mar 3, 2017, 6:06:10 PM
    Author     : zaccianflone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Post</title>
         <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h3>Welcome ${username}!</h3>
        <hr/>
        <br/>
        
    
          <form method="post" action="CreatePost">
            <input style ="visibility: hidden;" type="text" name="Username" value="skipToPosts">
            <br/>
            <input type="submit" class="btn btn-info" value="View Posts">
        </form>
        
       
        <form method="post" action="CreatePost">
            <div class="form-group">
                <label for="newPost">New Post:</label>
                <textarea class="form-control" rows="5" id="newPost" name="postText"></textarea>
            </div>
            
            <br/>
            <input style ="visibility: hidden;" type="text" name="Username" value="${username}">
            <br/>
            <input type="submit" class="btn btn-info" value="Submit Button">
        </form>
        
    </body>
</html>
