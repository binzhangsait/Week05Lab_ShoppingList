<%-- 
    Document   : shoppingList
    Created on : Feb 7, 2020, 6:58:26 PM
    Author     : 798419
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>

        <!--Hello,  ${sessionScope.userName} <a href="/Week05Lab_ShoppingList/ShoppingList">Logout</a>-->
        <!--Hello,  ${sessionScope.userName} <a href="/Week05Lab_ShoppingList/ShoppingList?action=logout">Logout</a>-->
        Hello,  ${sessionScope.username} <a href="?action=logout">Logout</a>
        <%--<c:remove var="userName"></c:remove>--%>
        <br>
        <h1>List</h1>
        <br>
        <!--<form method="POST">-->
        <!--<form action="add" method="POST">-->
        <form method="post">
            <input type="hidden"name="action" value="add" />
            Add item: <input type="text" name="fldItem">
            <button type="submit" name="action" value="add">Add</button>

        </form>

        <br>


        <form method="post">
           <input type="hidden" name="action" value="delete" />
            <c:forEach var="item" items="${items}" varStatus="status">
                <input type="radio" name="radSelect" value="${status.index}" />${item}<br />
            </c:forEach>
            <c:if test="${items.size() > 0}">
                <input type="submit" name="btnSubmit" value="Delete" />
            </c:if>
        </form>



        <hr>
        ${guestcount}

    </body>
</html>
