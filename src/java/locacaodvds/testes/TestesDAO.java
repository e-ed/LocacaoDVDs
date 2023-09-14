/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.testes;

import locacaodvds.dao.AtorDAO;
import java.sql.SQLException;
import java.sql.Date;
import locacaodvds.entidades.Ator;

/**
 *
 * @author eduardo
 */
public class TestesDAO {

    public static void main(String[] args) {
        AtorDAO ad = null;

        try {
            ad = new AtorDAO();

            //ad.salvar(new Ator("didi", "moco", Date.valueOf("2000-01-01")));

            ad.listarTodos().forEach((ator) -> {
                System.out.println(ator.getId() + " - " + ator.getNome() + " - " + ator.getSobrenome() + " - " + ator.getData_estreia());
            }
            );

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
        }
    }
}
