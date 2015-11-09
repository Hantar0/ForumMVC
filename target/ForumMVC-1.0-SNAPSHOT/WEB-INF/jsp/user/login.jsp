<%-- 
    Document   : login
    Created on : 28 oct. 2015, 14:16:29
    Author     : ETY
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <!-- On importe les autres pages pour le template -->
        <c:import url="../template/_titre.jsp"/>
        <c:import url="../template/_menu.jsp"/>
            <div class="contenu" >
                <p>Sélectionner login et mot de passe</p>
            <c:if test="${failLog==true}">
                <p>Mot de passe ou login erroné !</p>
                &nbsp;&nbsp;&nbsp;    
            </c:if>
            <form method="POST" action="login">
                <label for="login">Login : </label>
                <input type="text" id="login" name="login"/>
                <br>
                <label for="mdp">Mot de passe : </label>
                <input type="password" id="mdp" name="mdp"/>
                <br>
                <button type="submit" value="valider">Valider</button>
            </form>
        </div>
        <c:import url="../template/_pied.jsp"/>    
    </body>
</html>
