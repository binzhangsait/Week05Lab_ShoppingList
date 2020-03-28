<%-- 
    Document   : register
    Created on : Feb 7, 2020, 6:58:08 PM
    Author     : 798419
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1><br>
        <h2>Register</h2><br>

        <!--<form action="register" method="POST">-->
        <form method="POST">
            <!--<input type="hidden" name="action" value="register" />-->
            UserName: <input type="text" name="fldUsername" value="">
            <button type="submit" name="action" value="register">Register Name</button>
        </form>



        <br>
        <hr>
        ${guestcount}
    </body>
</html>
