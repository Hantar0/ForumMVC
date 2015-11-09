<%-- 
    Document   : _template
    Created on : 28 oct. 2015, 14:14:39
    Author     : ETY
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <c:import url="template/_javascripts.jsp"/>
        <c:import url="template/_stylesheets.jsp"/>
    </head>
    <body>
        <c:import url="template/_titre.jsp"/>
        <c:import url="template/_menu.jsp"/>
        <div class="contenu">
            Description du site
        </div>
        <c:import url="template/_pied.jsp"/>
    </body>
</html>
