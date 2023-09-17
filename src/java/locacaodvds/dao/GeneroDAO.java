/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.entidades.Genero;

/**
 *
 * @author eduardo
 */
public class GeneroDAO extends DAO<Genero> {

    public GeneroDAO() throws SQLException {

    }

    @Override
    public void salvar(Genero obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO "
                + "genero(descricao) "
                + "VALUES( ? );");

        stmt.setString(1, obj.getDescricao());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Genero obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement("update genero "
                + "set descricao = ? where id = ?;"
        );

        stmt.setString(1, obj.getDescricao());
        stmt.setInt(2, obj.getId());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Genero obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement("delete from genero where id = ?;");
        stmt.setInt(1, obj.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Genero> listarTodos() throws SQLException {
        List<Genero> generos = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement("select * from genero;");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Genero g = new Genero();
            g.setId(rs.getInt("id"));
            g.setDescricao(rs.getString("descricao"));
            generos.add(g);
        }

        rs.close();
        stmt.close();
        return generos;

    }

    @Override
    public Genero obterPorId(int id) throws SQLException {
        Genero g = null;
        PreparedStatement stmt = getConnection().prepareStatement("select * from genero where id = ?;");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            g = new Genero();
            g.setDescricao(rs.getString("descricao"));
        }
        rs.close();
        stmt.close();
        return g;
    }

}
