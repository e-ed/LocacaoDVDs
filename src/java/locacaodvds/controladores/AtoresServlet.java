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
import locacaodvds.dao.AtorDAO;
import java.sql.SQLException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import locacaodvds.entidades.Ator;

/**
 *
 * @author eduardo
 */
@WebServlet(name = "AtoresServlet", urlPatterns = {"/processaAtores"})
public class AtoresServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        AtorDAO atorDAO = null;
        RequestDispatcher disp = null;

        try {
            atorDAO = new AtorDAO();
            switch (request.getParameter("acao")) {
                case "inserir":
                    Ator ator = new Ator();
                    ator.setNome(request.getParameter("nome"));
                    ator.setSobrenome(request.getParameter("sobrenome"));
                    ator.setData_estreia(Date.valueOf(request.getParameter("data_estreia")));
                    atorDAO.salvar(ator);
                    disp = request.getRequestDispatcher("/formularios/ator/listagem.jsp");
                    break;
                case "alterar":
                    Ator atorSendoAtualizado = new Ator();
                    atorSendoAtualizado.setId(Integer.valueOf(request.getParameter("id")));
                    atorSendoAtualizado.setNome(request.getParameter("nome"));
                    atorSendoAtualizado.setSobrenome(request.getParameter("sobrenome"));
                    atorSendoAtualizado.setData_estreia(Date.valueOf(request.getParameter("data_estreia")));
                    atorDAO.atualizar(atorSendoAtualizado);
                    disp = request.getRequestDispatcher("/formularios/ator/listagem.jsp");
                    break;
                case "excluir":
                    Ator atorSendoExcluido = new Ator();
                    atorSendoExcluido.setId(Integer.valueOf(request.getParameter("id")));
                    atorDAO.excluir(atorSendoExcluido);
                    disp = request.getRequestDispatcher("/formularios/ator/listagem.jsp");
                    break;
            }
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Operação inválida!");
            request.setAttribute("voltar", "formularios/ator/listagem.jsp");
            disp = request.getRequestDispatcher("/erro/erro.jsp");
            disp.forward(request, response);
            e.printStackTrace();
        } finally {
            if (atorDAO != null) {
                try {
                    atorDAO.fecharConexao();
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
