package com.example.gestionvoitureproprietairej2ee.controllers;


import com.example.gestionvoitureproprietairej2ee.dao.GenericDao;
import com.example.gestionvoitureproprietairej2ee.dao.implementation.ProprietaireDaoImpl;
import com.example.gestionvoitureproprietairej2ee.entities.Proprietaire;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/proprietaire/*")
public class ProprietaireServlet  extends HttpServlet {

    GenericDao<Proprietaire, Integer> dao1 = new ProprietaireDaoImpl();
    
    @Override
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException,
            ServletException {
        String action = request.getPathInfo();
        if (action == null){
            action = "/list";
        }
        switch (action){
            case "/list" :
                try {
                    listProprietaires(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/add" :
                try {
                    showAddForm(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/edit" :
                try {
                    showEditForm(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/delete" :
                try {
                    showDeleteForm(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

@Override
    protected void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException {
        String action = request.getPathInfo();
        switch (action){
            case "/save" :
                try {
                    saveProprietaire(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/update" :
                try {
                    updateProprietaire(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/delete" :
                try {
                    deleteProprietaire(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default: response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

    }
    //------------- doGet impl ----------------------------
    private void listProprietaires(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        request.setAttribute("proprietaires",dao1.findAll());
        request.getRequestDispatcher("/WEB-INF/proprietaire/list.jsp").forward(request,response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,SQLException {
        request.getRequestDispatcher("/WEB-INF/proprietaire/addForm.jsp").forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        Proprietaire proprietaire = dao1.findById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("proprietaire",proprietaire);
        request.getRequestDispatcher("/WEB-INF/proprietaire/editForm.jsp").forward(request,response);

    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        Proprietaire proprietaire = dao1.findById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("proprietaire",proprietaire);
        request.getRequestDispatcher("/WEB-INF/proprietaire/delete.jsp").forward(request,response);
    }

    //----------- deGet impl ----------------------------
    private void saveProprietaire(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Proprietaire proprietaire = new Proprietaire();
        proprietaire.setNom(request.getParameter("nom"));
        proprietaire.setPrenom(request.getParameter("prenom"));
        proprietaire.setCin(request.getParameter("cin"));
        dao1.save(proprietaire);
        response.sendRedirect(request.getContextPath()+"/proprietaire/list");
    }

    private void updateProprietaire(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        Proprietaire proprietaire = new Proprietaire(request.getParameter("nom"),
                request.getParameter("prenom"),
                request.getParameter("cin"));
        proprietaire.setId(Integer.parseInt(request.getParameter("id")));
        dao1.update(proprietaire);
        response.sendRedirect(request.getContextPath()+"/proprietaire/list");
    }

    private void deleteProprietaire(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            dao1.delete(id);
            response.sendRedirect(request.getContextPath()+"/proprietaire/list");
    }

}
