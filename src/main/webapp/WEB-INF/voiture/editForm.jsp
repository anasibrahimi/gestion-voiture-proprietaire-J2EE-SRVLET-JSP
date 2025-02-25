<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Voiture</title>
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
                    <a class="nav-link" href="${pageContext.request.contextPath}/voiture">Gestion des Voitures</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <h1 class="mt-5">Modifier une Voiture</h1>
    <form action="${pageContext.request.contextPath}/voiture/update" method="post">
        <input type="hidden" name="id" value="${voiture.id}">
        <div class="mb-3">
            <label for="marque" class="form-label">Marque :</label>
            <input class="form-control" type="text" id="marque" name="marque" value="${voiture.marque}">
        </div>
        <div class="mb-3">
            <label for="modele" class="form-label">Modele :</label>
            <input class="form-control" type="text" id="modele" name="modele" value="${voiture.modele}">
        </div>
        <div class="mb-3">
            <label for="matricule" class="form-label">Matricule :</label>
            <input class="form-control" type="text" id="matricule" name="matricule" value="${voiture.matricule}">
        </div>
        <div class="mb-3">
            <label for="proprietaireId" class="form-label">Propritaire</label>
            <select class="form-select" id="proprietaireId" name="proprietaireId" required>
                <option value="">Sélectionner un Proprietaire</option>
                <c:forEach items="${proprietaires}" var="prop">
                    <option value="${prop.id}">
                            ${prop.nom} ${prop.prenom}
                    </option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary mb-3">Mettre a jour</button>
        <div>
            <a href="${pageContext.request.contextPath}/voiture/list" class="btn btn-secondary" >Annuler</a>
        </div>
    </form>
</div>
</body>
</html>
