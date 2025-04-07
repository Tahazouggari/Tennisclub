<%--
  Created by IntelliJ IDEA.
  User: zouggari-taha
  Date: 4/6/25
  Time: 6:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="fr.ensicaen.tennis.persistence.AdherentEntity" %>
<%@ page import="fr.ensicaen.tennis.persistence.InscriptionEntity" %>
<%@ page import="fr.ensicaen.tennis.persistence.TournoiEntity" %>

<%
    AdherentEntity adherent = (AdherentEntity) request.getAttribute("adherent");
    if (adherent == null) {
        response.sendRedirect("login.html");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/adherent.css">

    <title>Dossier Adhérent</title>
</head>
<body>
<jsp:include page="header.jsp" />

<h2>Dossier de <%= adherent.getPrenom() %> <%= adherent.getNom() %></h2>
<p><strong>Adresse :</strong> <%= adherent.getAdresse() %></p>
<p><strong>Téléphone :</strong> <%= adherent.getTelephone() %></p>
<p><strong>Email :</strong> <%= adherent.getEmail() %></p>

<h3>Tournois inscrits :</h3>

<%
    if (adherent.getInscriptions() == null || adherent.getInscriptions().isEmpty()) {
%>
<p>Aucune inscription à ce jour.</p>
<%
} else {
%>
<ul>
    <% for (InscriptionEntity i : adherent.getInscriptions()) {
        TournoiEntity tournoi = i.getTournoi(); %>
    <li><%= tournoi.getNom() %> – <%= tournoi.getDate() %> à <%= tournoi.getLieu() %></li>
    <% } %>
</ul>
<%
    }
%>

<jsp:include page="retour.jsp" />
</body>
</html>

