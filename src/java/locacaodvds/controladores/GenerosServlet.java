/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package locacaodvds.controladores;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import locacaodvds.dao.GeneroDAO;
import locacaodvds.entidades.Genero;

/**
 *
 * @author eduardo
 */
@WebServlet(name = "GenerosServlet", urlPatterns = {"/processaGeneros"})
public class GenerosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher disp = null;
        GeneroDAO generoDAO = null;

        switch (request.getParameter("acao")) {
            case "inserir":
                Genero genero = new Genero();
                try {
                    generoDAO = new GeneroDAO();
                    genero.setDescricao(request.getParameter("descricao"));
                    generoDAO.salvar(genero);
                    disp = request.getRequestDispatcher("/formularios/genero/listagem.jsp");

                } catch (Exception e) {
                    e.printStackTrace();

                } finally {
                    if (generoDAO != null) {
                        try {
                            generoDAO.fecharConexao();
                        } catch (SQLException ex) {
                            Logger.getLogger(GenerosServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                break;

            case "excluir": {
                try {
                    generoDAO = new GeneroDAO();
                    Genero generoSendoExcluido = new Genero();
                    generoSendoExcluido.setId(Integer.valueOf(request.getParameter("id")));
                    generoDAO.excluir(generoSendoExcluido);
                    disp = request.getRequestDispatcher("/formularios/genero/listagem.jsp");

                } catch (SQLException ex) {
                    Logger.getLogger(GenerosServlet.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    if (generoDAO != null) {
                        try {
                            generoDAO.fecharConexao();
                        } catch (SQLException ex) {
                            Logger.getLogger(GenerosServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

            break;

        }

        if (disp != null) {
            disp.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
