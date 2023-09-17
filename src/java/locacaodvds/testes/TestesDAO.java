/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.testes;

import locacaodvds.dao.AtorDAO;
import java.sql.SQLException;
import java.sql.Date;
import locacaodvds.dao.ClassificacaoEtariaDAO;
import locacaodvds.dao.DVDDAO;
import locacaodvds.dao.GeneroDAO;
import locacaodvds.entidades.Ator;
import locacaodvds.entidades.ClassificacaoEtaria;
import locacaodvds.entidades.DVD;
import locacaodvds.entidades.Genero;

/**
 *
 * @author eduardo
 */
public class TestesDAO {

    public static void main(String[] args) {
        GeneroDAO gd = null;
        AtorDAO ad = null;
        ClassificacaoEtariaDAO ced = null;
        DVDDAO dvddao = null;

        try {
            ad = new AtorDAO();
            gd = new GeneroDAO();
            ced = new ClassificacaoEtariaDAO();
            dvddao = new DVDDAO();
            gd.listarTodos().forEach((genero) -> {
                System.out.println(genero.getId() + " - " + genero.getDescricao());
            });
            
//            DVD dvd = new DVD();
//            dvd.setTitulo("NOVOTITULO");
//            dvd.setAno_lancamento(2021);
//            dvd.setAtor_principal_id(1);
//            dvd.setAtor_coadjuvante_id(2);
//            dvd.setData_lancamento(Date.valueOf("1998-01-01"));
//            dvd.setDuracao_minutos(1000);
//            dvd.setClassificacao_etaria_id(2);
//            dvd.setGenero_id(2);
          
            
//            dvddao.salvar(dvd);
//            
//            dvddao.listarTodos().forEach((d) -> {
//                System.out.println(d.getId() + " - " + d.getTitulo() + "-" + 
//                        d.getAtor_principal_id() + " - " + d.getAtor_coadjuvante_id() + 
//                                "-" + d.getData_lancamento() + " - " + d.getDuracao_minutos() + 
//                                " - " + d.getClassificacao_etaria_id() + " - " + d.getGenero_id());
//            });
//            
//            System.out.println("Obter por id: " + dvddao.obterPorId(2));
            
           


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
            if (ced != null) {
                try {
                    ced.fecharConexao();
                } catch (Exception e) {
                    System.out.println("erro ao fechar");
                    e.printStackTrace();
                }
            }
        }
    }
}
