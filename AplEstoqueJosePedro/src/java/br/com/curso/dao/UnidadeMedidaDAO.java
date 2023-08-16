/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.dao;

import br.com.curso.model.UnidadeMedida;
import br.com.curso.utils.SingleConnection;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
/**
 *
 * @author 55179
 */
public class UnidadeMedidaDAO implements GenericDAO{

    private Connection conexao;

    public UnidadeMedidaDAO() throws Exception{
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
         UnidadeMedida oUnidadeMedida = ( UnidadeMedida) objeto;
            Boolean retorno = false;
                if (oUnidadeMedida.getId_unidadeMedida()== 0) {
                    retorno = this.inserir(oUnidadeMedida);
                } else {
                    retorno = this.alterar(oUnidadeMedida);
                }
                  return retorno;    
    }

    @Override
    public Boolean inserir(Object objeto) {
        UnidadeMedida oUnidadeMedida = (UnidadeMedida) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into UnidadeMedida (descricao, sigla)"
                + "values(?,?)";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oUnidadeMedida.getDescricao());
            stmt.setString(2, oUnidadeMedida.getSigla());
            stmt.execute();
            conexao.commit();
            return true;
        }catch(Exception ex){
            try{
                System.out.println("Problemas ao cadastrar a UnidadeMedida: "+ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            }catch (SQLException e){
                System.out.println("Erro: "+ex.getMessage());
                ex.printStackTrace();
            }
        }
        
        return false;
    }

    @Override
    public Boolean alterar(Object objeto) {
    UnidadeMedida oUnidadeMedida = (UnidadeMedida) objeto;
        PreparedStatement stmt = null;
        String sql = "update UnidadeMedida set descricao =?, sigla =? where id_unidadeMedida=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oUnidadeMedida.getDescricao());
            stmt.setString(2, oUnidadeMedida.getSigla());
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception ex){
            try{
                System.out.println("Problemas ao alterar a UnidadeMedida! Erro:");
                ex.printStackTrace();
                conexao.rollback();
            }catch (SQLException e){
                System.out.println("Erro: "+e.getMessage());
                e.printStackTrace();
            }
            return false;
        }    
    }

    @Override
    public Boolean excluir(int numero) {
        int id_unidadeMedida = numero;
            PreparedStatement stmt = null;
        
            String sql = "delete from UnidadeMedida where id_unidadeMedida=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id_unidadeMedida);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex){
            System.out.println("Problemas ao excluir o UnidadeMedida! Erro: "
                    +ex.getMessage());
            try {
                conexao.rollback();
            } catch (SQLException e){
                System.out.println("Erro rollback"+e.getMessage());
                e.printStackTrace();
            }
            return false;
        }    
    }

    @Override
    public Object carregar(int numero) {
    int id_unidadeMedida = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UnidadeMedida oUnidadeMedida = null;
        String sql = "select * from UnidadeMedida where id_unidadeMedida=?";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id_unidadeMedida);
            rs=stmt.executeQuery();
            while (rs.next()) {
                oUnidadeMedida = new UnidadeMedida();
                oUnidadeMedida.setId_unidadeMedida(rs.getInt("id_unidadeMedida"));
                oUnidadeMedida.setDescricao(rs.getString("descricao"));
                oUnidadeMedida.setSigla(rs.getString("sigla"));
            }
            return oUnidadeMedida;
        } catch (Exception ex){
            System.out.println("Problemas ao carregar UnidadeMedida!"+ex.getMessage());
            return false;
        }     
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from UnidadeMedida order by id_unidadeMedida";
        try{
            stmt = conexao.prepareStatement(sql);
            rs=stmt.executeQuery();
            while (rs.next()){
                UnidadeMedida oUnidadeMedida = new UnidadeMedida();
                oUnidadeMedida.setId_unidadeMedida(rs.getInt("id_unidadeMedida"));
                oUnidadeMedida.setDescricao(rs.getString("descricao"));
                oUnidadeMedida.setSigla(rs.getString("sigla"));
            }
        }catch(SQLException ex){
            System.out.println("Problemas ao listar Unidade Medida! Erro: " +ex.getMessage());
        }
        return resultado;    
    }
}
