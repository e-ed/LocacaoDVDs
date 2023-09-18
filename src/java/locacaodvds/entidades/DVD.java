/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.entidades;
import java.sql.Date;
/**
 *
 * @author eduardo
 */
public class DVD {
    private int id;
    
    private String titulo;
    
    private int ano_lancamento;
    
    private int ator_principal_id;
    
    private String ator_principal_nome;
    
    private int ator_coadjuvante_id;
    
    private String ator_coadjuvante_nome;

    public String getAtor_principal_nome() {
        return ator_principal_nome;
    }

    public void setAtor_principal_nome(String ator_principal_nome) {
        this.ator_principal_nome = ator_principal_nome;
    }

    public String getAtor_coadjuvante_nome() {
        return ator_coadjuvante_nome;
    }

    public void setAtor_coadjuvante_nome(String ator_coadjuvante_nome) {
        this.ator_coadjuvante_nome = ator_coadjuvante_nome;
    }
    private Date data_lancamento;
    private int duracao_minutos;
    private int classificacao_etaria_id;
    private String classificacao_etaria_descricao;
    private int genero_id;
    private String genero_descricao;

    public String getClassificacao_etaria_descricao() {
        return classificacao_etaria_descricao;
    }

    public void setClassificacao_etaria_descricao(String classificacao_etaria_descricao) {
        this.classificacao_etaria_descricao = classificacao_etaria_descricao;
    }

    public String getGenero_descricao() {
        return genero_descricao;
    }

    public void setGenero_descricao(String genero_descricao) {
        this.genero_descricao = genero_descricao;
    }

    public DVD() {
    }

    public DVD(String titulo, int ano_lancamento, int ator_principal_id, int ator_coadjuvante_id, Date data_lancamento, int duracao_minutos, int classificacao_etaria_id, int genero_id) {
        this.titulo = titulo;
        this.ano_lancamento = ano_lancamento;
        this.ator_principal_id = ator_principal_id;
        this.ator_coadjuvante_id = ator_coadjuvante_id;
        this.data_lancamento = data_lancamento;
        this.duracao_minutos = duracao_minutos;
        this.classificacao_etaria_id = classificacao_etaria_id;
        this.genero_id = genero_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno_lancamento() {
        return ano_lancamento;
    }

    public void setAno_lancamento(int ano_lancamento) {
        this.ano_lancamento = ano_lancamento;
    }

    public int getAtor_principal_id() {
        return ator_principal_id;
    }

    public void setAtor_principal_id(int ator_principal_id) {
        this.ator_principal_id = ator_principal_id;
    }

    public int getAtor_coadjuvante_id() {
        return ator_coadjuvante_id;
    }

    public void setAtor_coadjuvante_id(int ator_coadjuvante_id) {
        this.ator_coadjuvante_id = ator_coadjuvante_id;
    }

    public Date getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(Date data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public int getDuracao_minutos() {
        return duracao_minutos;
    }

    public void setDuracao_minutos(int duracao_minutos) {
        this.duracao_minutos = duracao_minutos;
    }

    public int getClassificacao_etaria_id() {
        return classificacao_etaria_id;
    }

    public void setClassificacao_etaria_id(int classificacao_etaria_id) {
        this.classificacao_etaria_id = classificacao_etaria_id;
    }

    public int getGenero_id() {
        return genero_id;
    }

    public void setGenero_id(int genero_id) {
        this.genero_id = genero_id;
    }
    
    
    
    
    
}
