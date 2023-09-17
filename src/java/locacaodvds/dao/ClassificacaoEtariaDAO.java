/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.entidades.Ator;
import locacaodvds.entidades.ClassificacaoEtaria;

/**
 *
 * @author eduardo
 */
public class ClassificacaoEtariaDAO extends DAO<ClassificacaoEtaria> {

    public ClassificacaoEtariaDAO() throws SQLException {

    }

    @Override
    public void salvar(ClassificacaoEtaria obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "insert into classificacao_etaria(descricao) values (?);"
        );
        stmt.setString(1, obj.getDescricao());
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public void atualizar(ClassificacaoEtaria obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
        "update classificacao_etaria set descricao = ? where id = ?;"
        );
        stmt.setString(1, obj.getDescricao());
        stmt.setInt(2, obj.getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(ClassificacaoEtaria obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
        "delete from classificacao_etaria where id = ?;"
        );
        stmt.setInt(1, obj.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<ClassificacaoEtaria> listarTodos() throws SQLException {
        List<ClassificacaoEtaria> list = new ArrayList<>();
        
        PreparedStatement stmt = getConnection().prepareStatement("select * from classificacao_etaria;");
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            ClassificacaoEtaria c = new ClassificacaoEtaria();
            c.setId(rs.getInt("id"));
            c.setDescricao(rs.getString("descricao"));
            
            list.add(c);
        }
        
        rs.close();
        stmt.close();
        return list;
    }

    @Override
    public ClassificacaoEtaria obterPorId(int id) throws SQLException {
        ClassificacaoEtaria c = null;
        PreparedStatement stmt = getConnection().prepareStatement(
        "select * from classificacao_etaria where id = ?;"
        );
        
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            c = new ClassificacaoEtaria();
            c.setId(rs.getInt("id"));
            c.setDescricao(rs.getString("descricao"));
        }
        rs.close();
        stmt.close();
        return c;
    }

}
