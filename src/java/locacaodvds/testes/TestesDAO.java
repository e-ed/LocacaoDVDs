/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.testes;

import locacaodvds.dao.AtorDAO;
import java.sql.SQLException;
import java.sql.Date;
import locacaodvds.dao.GeneroDAO;
import locacaodvds.entidades.Ator;
import locacaodvds.entidades.Genero;

/**
 *
 * @author eduardo
 */
public class TestesDAO {

    public static void main(String[] args) {
        GeneroDAO gd = null;
        AtorDAO ad = null;

        try {
            ad = new AtorDAO();
            gd = new GeneroDAO();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (ad != null) {
                try {
                    ad.fecharConexao();
                } catch (Exception e) {
                    System.out.println("erro ao fechar");
                    e.printStackTrace();
                }
            }
            if (gd != null) {
                try {
                    gd.fecharConexao();
                } catch (Exception e) {
                    System.out.println("erro ao fechar");
                    e.printStackTrace();
                }
            }
        }
    }
}
