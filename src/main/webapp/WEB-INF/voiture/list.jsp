<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anas
  Date: 2/23/2025
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List de voitures</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">Gestion Voiture et Proprietaire</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/proprietaire/list">Gestion des Proprietaires</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/voiture/list">Gestion des Voitures</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container mt-5">
    <h1 class="mt-5">Listes des voitures</h1>
    <div class="mb-3">
        <a href="${pageContext.request.contextPath}/voiture/add" class="btn btn-success">Ajouter un voitures</a>
    </div>
    <table  class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Marque</th>
            <th scope="col">Model</th>
            <th scope="col">Matricule</th>
            <th scope="col">Proprietaire</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${voitures}" var="vr">
            <tr>
                <th>${vr.id}</th>
                <td>${vr.marque}</td>
                <td>${vr.modele}</td>
                <td>${vr.matricule}</td>
                <td>${vr.getProprietaire().getPrenom()} ${vr.getProprietaire().getNom()}</td>
                <td>
                    <a href="<c:url value='/voiture/edit?id=${vr.id}'/>"
                       class="btn btn-sm btn-warning">Modifier</a>
                    <a href="<c:url value='/voiture/delete?id=${vr.id}'/>"
                       class="btn btn-sm btn-danger">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
