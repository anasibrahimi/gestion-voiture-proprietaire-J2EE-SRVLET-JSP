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
    <title>Ajouter un etudiant</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="mt-5">Ajouter une voiture</h1>
    <form action="save" method="post">
        <div class="mb-3">
            <label for="marque" class="form-label">Marque :</label>
            <input type="text" class="form-control" id="marque" name="marque">
        </div>
        <div class="mb-3">
            <label for="modele" class="form-label">Modele :</label>
            <input type="text" class="form-control" id="modele" name="modele">
        </div>
        <div class="mb-3">
            <label for="matricule" class="form-label">Matricule :</label>
            <input type="text" class="form-control" id="matricule" name="matricule">
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
        <button type="submit" class="btn btn-primary">Enregistrer</button>
    </form>
</div>

</body>
</html>
