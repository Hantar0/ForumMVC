<%-- 
    Document   : user_list
    Created on : 5 nov. 2015, 14:48:13
    Author     : kk
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
        <h1>Hello World!</h1>
        <c:forEach items="${users}" var="user">
            ${user.id}<br>
            ${user.login}<br>
            ${user.mdp}<br><br>
        </c:forEach><br>
    </body>
</html>
