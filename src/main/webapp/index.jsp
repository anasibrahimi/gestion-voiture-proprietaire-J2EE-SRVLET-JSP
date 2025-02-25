<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Gestion des Proprietaires et Voiture</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!-- Barre de navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp">Gestion Voiture et Proprietaire</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="proprietaire">Gestion des Proprietaires</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="voiture">Gestion des Voitures</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="container mt-5">
  <h1>Gestion des Proprietaires et Voiture</h1>

  <div class="row mt-4">
    <div class="col-md-4">
      <div class="card">
        <div class="card-body">
          <h5 class="card-title">Voitures</h5>
          <p class="card-text">Gérer les voitures</p>
          <a href="voiture" class="btn btn-primary">Accéder</a>
        </div>
      </div>
    </div>

    <div class="col-md-4">
      <div class="card">
        <div class="card-body">
          <h5 class="card-title">Proprietaires</h5>
          <p class="card-text">Gérer les prprietaires</p>
          <a href="proprietaire" class="btn btn-primary">Accéder</a>
        </div>
      </div>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>