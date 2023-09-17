/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.servicos;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import locacaodvds.dao.AtorDAO;
import locacaodvds.entidades.Ator;

/**
 *
 * @author eduardo
 */
public class AtorServices {
    public List<Ator> getTodos() {
        List<Ator> atores = null;
        AtorDAO atorDAO = null;
        
        try {
            atorDAO = new AtorDAO();
            atores = atorDAO.listarTodos();
        } catch (SQLException ex) {
            Logger.getLogger(AtorServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (atorDAO != null) {
                try {
                    atorDAO.fecharConexao();
                } catch (SQLException ex) {
                    Logger.getLogger(AtorServices.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return atores;
    }
}
