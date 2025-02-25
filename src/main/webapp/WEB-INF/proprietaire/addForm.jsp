<%--
  Created by IntelliJ IDEA.
  User: Anas
  Date: 2/23/2025
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un proprietaire</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="mt-5">Ajouter un proprietaire</h1>
    <form action="save" method="post">
        <div class="mb-3">
            <label for="nom" class="form-label">Nom :</label>
            <input type="text" class="form-control" name="nom" id="nom" >
        </div>
        <div class="mb-3">
            <label for="prenom" class="form-label">Prenom :</label>
            <input type="text" class="form-control" name="prenom" id="prenom" >
        </div>
        <div class="mb-3">
            <label for="cin" class="form-label">CIN :</label>
            <input type="text" class="form-control" name="cin" id="cin" >
        </div>
        <button type="submit" class="btn btn-primary">Enregistrer</button>
    </form>
</div>
</body>
</html>
