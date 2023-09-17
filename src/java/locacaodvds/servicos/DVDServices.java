/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.servicos;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import locacaodvds.dao.DVDDAO;
import locacaodvds.entidades.DVD;

/**
 *
 * @author eduardo
 */
public class DVDServices {

    public List<DVD> getTodos() {
        List<DVD> dvds = null;
        DVDDAO dvdDAO = null;

        try {
            dvdDAO = new DVDDAO();
            dvds = dvdDAO.listarTodos();
        } catch (SQLException ex) {
            Logger.getLogger(DVDServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (dvdDAO != null) {
                try {
                    dvdDAO.fecharConexao();
                } catch (SQLException ex) {
                    Logger.getLogger(DVDServices.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return dvds;

    }
}
