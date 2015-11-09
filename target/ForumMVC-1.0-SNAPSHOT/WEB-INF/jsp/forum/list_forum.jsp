<%-- 
    Document   : _template
    Created on : 28 oct. 2015, 14:14:39
    Author     : ETY
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <c:import url="../template/_javascripts.jsp"/>
        <c:import url="../template/_stylesheets.jsp"/>
    </head>
    <body>
        <c:import url="../template/_titre.jsp"/>
        <c:import url="../template/_menu.jsp"/>
        <div class="contenu">
            <h1><spring:message code="forum.list.name"/></h1>
            <table>
                <tr>
                    <th>Nom</th>
                    <th>Administrateur</th>
                </tr>
                <c:forEach items="${forums}" var="forum">
                    <tr>
                        <td>${forum.name}</td>
                        <td>${forum.administrateur.login}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <c:import url="../template/_pied.jsp"/>
    </body>
</html>
