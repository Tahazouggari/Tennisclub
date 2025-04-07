<%--
  Created by IntelliJ IDEA.
  User: zouggari-taha
  Date: 4/6/25
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="fr.ensicaen.tennis.persistence.AdherentEntity" %>
<%@ page session="true" %>

<%
    AdherentEntity adherent = (AdherentEntity) session.getAttribute("adherent");
    if (adherent == null) {
        response.sendRedirect("login.html");
        return;
    }
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Menu principal</title>
    <link rel="stylesheet" href="css/menu.css">

</head>
<body>

<jsp:include page="header.jsp" />

<h1>Bienvenue, <%= adherent.getPrenom() %> <%= adherent.getNom() %> !</h1>

<form method="POST" action="action">
    <input type="hidden" name="code" value="A" />
    <button type="submit">Consultation de votre dossier adhérent</button>
</form>

<form method="POST" action="action">
    <input type="hidden" name="code" value="I" />
    <button type="submit">Inscription à un tournoi</button>
</form>

</body>
</html>
