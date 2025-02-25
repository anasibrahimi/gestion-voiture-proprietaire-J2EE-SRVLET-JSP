package com.example.gestionvoitureproprietairej2ee.controllers;


import com.example.gestionvoitureproprietairej2ee.dao.GenericDao;
import com.example.gestionvoitureproprietairej2ee.dao.implementation.ProprietaireDaoImpl;
import com.example.gestionvoitureproprietairej2ee.dao.implementation.VoitureDaoImpl;
import com.example.gestionvoitureproprietairej2ee.entities.Proprietaire;
import com.example.gestionvoitureproprietairej2ee.entities.Voiture;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/voiture/*")
public class VoitureServlet extends HttpServlet {

    GenericDao<Voiture, Integer> dao = new VoitureDaoImpl();
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
                    listVoitures(request,response);
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
                    saveVoiture(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/update" :
                try {
                    updateVoiture(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/delete" :
                try {
                    deleteVoiture(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default: response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    //----------------  doGet implementation methodes -----------------------
    private void listVoitures(HttpServletRequest request,
                              HttpServletResponse response) throws SQLException,
            ServletException, IOException {
        List<Voiture> voitureList = (List<Voiture>) dao.findAll();
        request.setAttribute("voitures",voitureList);
        request.getRequestDispatcher("/WEB-INF/voiture/list.jsp").forward(request,response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        List<Proprietaire> proprietaireList = (List<Proprietaire>) dao1.findAll();
        request.setAttribute("proprietaires",proprietaireList);
        request.getRequestDispatcher("/WEB-INF/voiture/addForm.jsp").forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Voiture voiture = dao.findById(id);
        request.setAttribute("voiture",voiture);
        List<Proprietaire> proprietaireList = (List<Proprietaire>) dao1.findAll();
        request.setAttribute("proprietaires",proprietaireList);
        request.getRequestDispatcher("/WEB-INF/voiture/editForm.jsp").forward(request,response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Voiture voiture = (Voiture) dao.findById(id);
        request.setAttribute("voiture",voiture);
        request.getRequestDispatcher("/WEB-INF/voiture/delete.jsp").forward(request,response);
    }
    //----------------  doPost implementation methodes -----------------------
    private void saveVoiture(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String marque = request.getParameter("marque");
        String modele = request.getParameter("modele");
        String matricule = request.getParameter("matricule");
        int proprietaireId_id = Integer.parseInt(request.getParameter("proprietaireId"));
        Proprietaire proprietaire = dao1.findById(proprietaireId_id);
        Voiture voiture = new Voiture(marque,modele,matricule,proprietaire);
        dao.save(voiture);
        response.sendRedirect(request.getContextPath() + "/voiture/list");
    }

    private void updateVoiture(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String marque = request.getParameter("marque");
        String modele = request.getParameter("modele");
        String matricule = request.getParameter("matricule");
        int proprietaireId = Integer.parseInt(request.getParameter("proprietaireId"));
        Proprietaire proprietaire = dao1.findById(proprietaireId);
        Voiture voiture = new Voiture(marque,modele,matricule,proprietaire);
        voiture.setId(id);
        dao.update(voiture);
        response.sendRedirect(request.getContextPath() +"/voiture/list");
    }

    private void deleteVoiture(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        dao.delete(id);
        response.sendRedirect(request.getContextPath()+"/voiture/list");
    }

}
