<%--
  Created by IntelliJ IDEA.
  User: zouggari-taha
  Date: 4/7/25
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="fr.ensicaen.tennis.persistence.TournoiEntity" %>
<%@ page import="java.util.List" %>
<%
  List<TournoiEntity> tournois = (List<TournoiEntity>) request.getAttribute("tournois");
%>

<!DOCTYPE html>
<html>
<head>
  <title>Inscription à un tournoi</title>
  <link rel="stylesheet" href="css/inscription_tournois.css">

</head>
<body>
<jsp:include page="header.jsp" />

<h2>Liste des tournois</h2>

<table border="1">
  <tr><th>Code</th><th>Nom</th><th>Date</th><th>Lieu</th><th>Action</th></tr>
  <% for (TournoiEntity t : tournois) { %>
  <tr>
    <td><%= t.getCodeTournoi() %></td>
    <td><%= t.getNom() %></td>
    <td><%= t.getDate() %></td>
    <td><%= t.getLieu() %></td>
    <td>
      <form method="POST" action="action">
        <input type="hidden" name="code" value="I"/>
        <input type="hidden" name="tournoi" value="<%= t.getCodeTournoi() %>"/>
        <button type="submit">Inscription</button>
      </form>
    </td>
  </tr>
  <% } %>
</table>

<jsp:include page="retour.jsp" />
</body>
</html>
