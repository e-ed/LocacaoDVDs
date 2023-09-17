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
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import locacaodvds.dao.AtorDAO;
import locacaodvds.dao.ClassificacaoEtariaDAO;
import locacaodvds.entidades.Ator;
import locacaodvds.entidades.ClassificacaoEtaria;

/**
 *
 * @author eduardo
 */
@WebServlet(name = "ClassificacoesEtariasServlet", urlPatterns = {"/processaClassificacoesEtarias"})
public class ClassificacoesEtariasServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ClassificacaoEtariaDAO classificacaoEtariaDAO = null;
        RequestDispatcher disp = null;

        try {
            classificacaoEtariaDAO= new ClassificacaoEtariaDAO();
            switch (request.getParameter("acao")) {
                case "inserir":
                    ClassificacaoEtaria c = new ClassificacaoEtaria();
                    c.setDescricao(request.getParameter("descricao"));
                    classificacaoEtariaDAO.salvar(c);
                    disp = request.getRequestDispatcher("/formularios/classificacao_etaria/listagem.jsp");
                    break;
                case "alterar":
                    ClassificacaoEtaria cl = new ClassificacaoEtaria();
                    cl.setId(Integer.valueOf(request.getParameter("id")));
                    cl.setDescricao(request.getParameter("descricao"));
                    classificacaoEtariaDAO.atualizar(cl);
                    disp = request.getRequestDispatcher("/formularios/classificacao_etaria/listagem.jsp");
                    break;
                case "excluir":
                    ClassificacaoEtaria cla = new ClassificacaoEtaria();
                    cla.setId(Integer.valueOf(request.getParameter("id")));
                    classificacaoEtariaDAO.excluir(cla);
                    disp = request.getRequestDispatcher("/formularios/classificacao_etaria/listagem.jsp");
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (classificacaoEtariaDAO != null) {
                try {
                    classificacaoEtariaDAO.fecharConexao();
                } catch (SQLException ex) {
                    Logger.getLogger(AtoresServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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