/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.servicos;

import java.util.List;
import locacaodvds.dao.GeneroDAO;
import locacaodvds.entidades.Genero;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduardo
 */
public class GeneroServices {
    public List<Genero> getTodos() {
        List<Genero> generos = new ArrayList<>();
        GeneroDAO g = null;
        
        try {
            g = new GeneroDAO();
            generos = g.listarTodos();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            if (g != null) {
                try {
                    g.fecharConexao();
                } catch (SQLException ex) {
                    Logger.getLogger(GeneroServices.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return generos;
        
    }
    
    
    
}
