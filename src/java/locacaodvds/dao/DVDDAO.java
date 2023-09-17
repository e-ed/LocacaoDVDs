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
import locacaodvds.entidades.DVD;

/**
 *
 * @author eduardo
 */
public class DVDDAO extends DAO<DVD> {

    public DVDDAO() throws SQLException {}
    

    @Override
    public void salvar(DVD obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "insert into dvd(titulo, ano_lancamento, ator_principal_id, ator_coadjuvante_id,"
                + " data_lancamento, duracao_minutos, classificacao_etaria_id, genero_id) "
                + "values(?, ?, ?, ?, ?, ?, ?, ?); "
        );

        stmt.setString(1, obj.getTitulo());
        stmt.setInt(2, obj.getAno_lancamento());
        stmt.setInt(3, obj.getAtor_principal_id());
        stmt.setInt(4, obj.getAtor_coadjuvante_id());
        stmt.setDate(5, obj.getData_lancamento());
        stmt.setInt(6, obj.getDuracao_minutos());
        stmt.setInt(7, obj.getClassificacao_etaria_id());
        stmt.setInt(8, obj.getGenero_id());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(DVD obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "update dvd set titulo = ?, ano_lancamento = ?, ator_principal_id = ?, "
                        + "ator_coadjuvante_id = ?, data_lancamento = ?, duracao_minutos = ?, "
                        + "classificacao_etaria_id = ?, genero_id = ? where id = ?;"
        );

        stmt.setString(1, obj.getTitulo());
        stmt.setInt(2, obj.getAno_lancamento());
        stmt.setInt(3, obj.getAtor_principal_id());
        stmt.setInt(4, obj.getAtor_coadjuvante_id());
        stmt.setDate(5, obj.getData_lancamento());
        stmt.setInt(6, obj.getDuracao_minutos());
        stmt.setInt(7, obj.getClassificacao_etaria_id());
        stmt.setInt(8, obj.getGenero_id());
        stmt.setInt(9, obj.getId());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(DVD obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
        "delete from dvd where id = ?;"
        );
        stmt.setInt(1, obj.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<DVD> listarTodos() throws SQLException {
        List<DVD> list = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement("select * from dvd");
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            DVD dvd = new DVD();
            dvd.setId(Integer.valueOf(rs.getString("id")));
            dvd.setTitulo(rs.getString("titulo"));
            dvd.setAno_lancamento(rs.getInt("ano_lancamento"));
            dvd.setAtor_principal_id(rs.getInt("ator_principal_id"));
            dvd.setAtor_coadjuvante_id(rs.getInt("ator_coadjuvante_id"));
            dvd.setData_lancamento(rs.getDate("data_lancamento"));
            dvd.setDuracao_minutos(rs.getInt("duracao_minutos"));
            dvd.setClassificacao_etaria_id(rs.getInt("classificacao_etaria_id"));
            dvd.setGenero_id(rs.getInt("genero_id"));
            
            list.add(dvd);
            
        }
        
        rs.close();
        stmt.close();
        return list;
    }

    @Override
    public DVD obterPorId(int id) throws SQLException {
        DVD dvd = null;
        
        PreparedStatement stmt = getConnection().prepareStatement("select * from dvd where id = ?;");
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            dvd = new DVD();
            dvd.setTitulo(rs.getString("titulo"));
            dvd.setAno_lancamento(rs.getInt("ano_lancamento"));
            dvd.setAtor_principal_id(rs.getInt("ator_principal_id"));
            dvd.setAtor_coadjuvante_id(rs.getInt("ator_coadjuvante_id"));
            dvd.setData_lancamento(rs.getDate("data_lancamento"));
            dvd.setDuracao_minutos(rs.getInt("duracao_minutos"));
            dvd.setClassificacao_etaria_id(rs.getInt("classificacao_etaria_id"));
            dvd.setGenero_id(rs.getInt("genero_id"));
        }
        
        rs.close();
        stmt.close();
        return dvd;
    }

}
