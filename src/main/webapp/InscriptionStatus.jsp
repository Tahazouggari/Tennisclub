<%--
  Created by IntelliJ IDEA.
  User: zouggari-taha
  Date: 4/7/25
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="fr.ensicaen.tennis.persistence.TournoiEntity" %>
<%
  TournoiEntity tournoi = (TournoiEntity) request.getAttribute("tournoi");
  Boolean dejaInscrit = (Boolean) request.getAttribute("dejaInscrit");
%>

<!DOCTYPE html>
<html>
<head><title>Inscription</title>
  <link rel="stylesheet" href="css/inscription_status.css">

</head>
<body>
<jsp:include page="header.jsp" />

<% if (dejaInscrit != null && dejaInscrit) { %>
<p style="color:red;">Vous êtes déjà inscrit au tournoi <strong><%= tournoi.getNom() %></strong> du
  <%= tournoi.getDate() %> à <%= tournoi.getLieu() %>.</p>
<% } else if (tournoi != null) { %>
<p> Inscription enregistrée pour le tournoi <strong><%= tournoi.getNom() %></strong> du
  <%= tournoi.getDate() %> à <%= tournoi.getLieu() %>.</p>
<% } else { %>
<p> Erreur : tournoi non trouvé ou données manquantes.</p>
<% } %>

<jsp:include page="retour.jsp" />
</body>
</html>
