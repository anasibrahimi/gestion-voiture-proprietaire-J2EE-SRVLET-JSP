<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Listes de proprietaires</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Gestion Voiture et Proprietaire</a>
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
    <h1 class="mt-5">Listes des proprietaires</h1>
    <div class="mb-3">
        <a  href=${pageContext.request.contextPath}/proprietaire/add class="btn btn-success">Ajouter un proprietaire</a>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prenom</th>
            <th>CIN</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${proprietaires}" var="prop">
            <tr>
                <td>${prop.id}</td>
                <td>${prop.nom}</td>
                <td>${prop.prenom}</td>
                <td>${prop.cin}</td>
                <td>
                    <a href="<c:url value='/proprietaire/edit?id=${prop.id}'/>"
                       class="btn btn-sm btn-warning">Modifier</a>
                    <a href="<c:url value='/proprietaire/delete?id=${prop.id}'/>"
                       class="btn btn-sm btn-danger">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
