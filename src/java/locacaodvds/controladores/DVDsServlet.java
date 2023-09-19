/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package locacaodvds.controladores;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import locacaodvds.dao.DVDDAO;
import locacaodvds.entidades.DVD;
import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author eduardo
 */
@WebServlet(name = "DVDsServlet", urlPatterns = {"/processaDVDs"})
public class DVDsServlet extends HttpServlet {

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
        DVDDAO dvdDAO = null;
        RequestDispatcher disp = null;

        String acao = request.getParameter("acao");
        String titulo = null;
        String ano_lancamento = null;
        String ator_principal_id = null;
        String data = null;
        if (acao.equals("inserir") || acao.equals("alterar")) {
            titulo = request.getParameter("titulo");
            ano_lancamento = request.getParameter("ano_lancamento");
            ator_principal_id = request.getParameter("ator_principal_id");
            data = request.getParameter("data_lancamento");

            Date data_lancamento = null;
            int year = Integer.valueOf(ano_lancamento);

            if (data != null) {
                data_lancamento = Date.valueOf(data);
                Calendar cal = Calendar.getInstance();
                cal.setTime(data_lancamento);
                year = cal.get(Calendar.YEAR);
            }

            if (titulo == null || titulo.isEmpty() || titulo.isBlank() || titulo.length() == 0
                    || ano_lancamento == null || ano_lancamento.isEmpty() || ano_lancamento.isBlank() || ano_lancamento.length() == 0 || Integer.valueOf(ano_lancamento) < 1
                    || ator_principal_id == null || ator_principal_id.isEmpty() || ator_principal_id.isBlank() || ator_principal_id.length() == 0
                    || !Integer.valueOf(ano_lancamento).equals(year)) {
                request.setAttribute("errorMessage", "Dados inválidos!");
                request.setAttribute("voltar", "formularios/dvd/listagem.jsp");
                disp = request.getRequestDispatcher("/erro/erro.jsp");
                disp.forward(request, response);
                return;
            }
        }
        try {
            dvdDAO = new DVDDAO();
            switch (acao) {
                case "inserir":
                    DVD dvd = new DVD();
                    dvd.setTitulo(request.getParameter("titulo"));
                    dvd.setAno_lancamento(Integer.valueOf(request.getParameter("ano_lancamento")));
                    dvd.setAtor_principal_id(Integer.valueOf(request.getParameter("ator_principal_id")));
                    dvd.setAtor_coadjuvante_id(Integer.valueOf(request.getParameter("ator_coadjuvante_id")));
                    dvd.setData_lancamento(Date.valueOf(request.getParameter("data_lancamento")));
                    dvd.setDuracao_minutos(Integer.valueOf(request.getParameter("duracao_minutos")));
                    dvd.setClassificacao_etaria_id(Integer.valueOf(request.getParameter("classificacao_etaria_id")));
                    dvd.setGenero_id(Integer.valueOf(request.getParameter("genero_id")));

                    dvdDAO.salvar(dvd);
                    disp = request.getRequestDispatcher("/formularios/dvd/listagem.jsp");
                    break;
                case "alterar":
                    DVD dvdAtualizado = new DVD();
                    dvdAtualizado.setId(Integer.valueOf(request.getParameter("id")));
                    dvdAtualizado.setTitulo(request.getParameter("titulo"));
                    dvdAtualizado.setAno_lancamento(Integer.valueOf(request.getParameter("ano_lancamento")));
                    dvdAtualizado.setAtor_principal_id(Integer.valueOf(request.getParameter("ator_principal_id")));
                    dvdAtualizado.setAtor_coadjuvante_id(Integer.valueOf(request.getParameter("ator_coadjuvante_id")));
                    dvdAtualizado.setData_lancamento(Date.valueOf(request.getParameter("data_lancamento")));
                    dvdAtualizado.setDuracao_minutos(Integer.valueOf(request.getParameter("duracao_minutos")));
                    dvdAtualizado.setClassificacao_etaria_id(Integer.valueOf(request.getParameter("classificacao_etaria_id")));
                    dvdAtualizado.setGenero_id(Integer.valueOf(request.getParameter("genero_id")));

                    dvdDAO.atualizar(dvdAtualizado);
                    disp = request.getRequestDispatcher("/formularios/dvd/listagem.jsp");
                    break;
                case "excluir":
                    DVD dvdExcluido = new DVD();
                    dvdExcluido.setId(Integer.valueOf(request.getParameter("id")));
                    dvdDAO.excluir(dvdExcluido);
                    disp = request.getRequestDispatcher("/formularios/dvd/listagem.jsp");
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (dvdDAO != null) {
                try {
                    dvdDAO.fecharConexao();
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
