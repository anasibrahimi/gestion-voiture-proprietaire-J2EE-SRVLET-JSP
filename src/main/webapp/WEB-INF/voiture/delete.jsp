<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Voiture</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
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
                    <a class="nav-link" href="">Gestion des Proprietaires</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="">Gestion des Voitures</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="card border-danger mb-3">
    <div class="card-body">
        <h5 class="card-title"> Voulez-vous vraiment supprimer cette voiture ?</h5>
        <p class="card-text">
            <strong>Marque :</strong>${voiture.marque}<br>
            <strong>Modele :</strong>${voiture.modele}<br>
            <strong>Matricule :</strong>${voiture.matricule}<br>
        </p>
        <form action="delete" method="post">
            <input type="hidden" name="id" value="${voiture.id}">
            <button type="submit" class="btn btn-danger">Confirmer</button>
            <a href="${pageContext.request.contextPath}/voiture/list" class="btn btn-secondary">Annuler</a>
        </form>
    </div>
</div>
</body>
</html>
