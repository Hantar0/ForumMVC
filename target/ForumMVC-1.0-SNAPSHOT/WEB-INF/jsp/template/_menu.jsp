<%-- 
    Document   : _menu
    Created on : 28 oct. 2015, 14:15:08
    Author     : ETY
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="menu"><br><br>
    <a href="<spring:url value="/" />">Accueil</a><br>
    <a href="lister_films">Films</a><br>
    <a href="">Series</a><br>
    <div class="menuLogin">
        <c:choose>
            <c:when test="${estLogge!=true}">
                <a href="login">Login</a>
            </c:when>
            <c:otherwise>
                <a href="logout">Logout</a> <br>
                Bonjour ${user} !
            </c:otherwise>
        </c:choose>
    </div>
</div>
