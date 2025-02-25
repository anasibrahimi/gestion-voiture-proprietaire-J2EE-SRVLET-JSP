<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Proprietaire</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/proprietaire/index.jsp">Gestion Voiture et Proprietaire</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/proprietaire">Gestion des Proprietaires</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href=${pageContext.request.contextPath}/voiture">Gestion des Voitures</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <h1 class="mt-5">Modifier un Proprietaire</h1>
    <form action="${pageContext.request.contextPath}/proprietaire/update" method="post">
        <input type="hidden" name="id" value="${proprietaire.id}">
        <div class="mb-3">
            <label for="nom" class="form-label">Nom :</label>
            <input class="form-control" type="text" id="nom" name="nom" value="${proprietaire.nom}">
        </div>
        <div class="mb-3">
            <label for="prenom" class="form-label">Prenom :</label>
            <input class="form-control" type="text" id="prenom" name="prenom" value="${proprietaire.prenom}">
        </div>
        <div class="mb-3">
            <label for="cin" class="form-label">CIN :</label>
            <input class="form-control" type="text" id="cin" name="cin" value="${proprietaire.cin}">
        </div>
        <button type="submit" class="btn btn-primary mb-3">Mettre a jour</button>
        <div>
            <a href="${pageContext.request.contextPath}/proprietaire/list" class="btn btn-secondary" >Annuler</a>
        </div>
    </form>
</div>
</body>
</html>
