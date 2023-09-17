/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.servicos;

import java.util.List;
import locacaodvds.dao.ClassificacaoEtariaDAO;
import locacaodvds.entidades.ClassificacaoEtaria;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduardo
 */
public class ClassificacaoEtariaServices {
    public List<ClassificacaoEtaria> getTodos() {
        List<ClassificacaoEtaria> list = null;
        ClassificacaoEtariaDAO c = null;
        
        try {
            c = new ClassificacaoEtariaDAO();
            list = c.listarTodos();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (c != null) {
                try {
                    c.fecharConexao();
                } catch (SQLException ex) {
                    Logger.getLogger(ClassificacaoEtariaServices.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return list;
    }
    
}
