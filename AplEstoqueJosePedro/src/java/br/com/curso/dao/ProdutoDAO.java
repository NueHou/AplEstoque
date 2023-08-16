/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.dao;

import br.com.curso.model.Produto;
import br.com.curso.model.TipoProduto;
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
 *
 * @author 55179
 */
public class ProdutoDAO implements GenericDAO{

    private Connection conexao;

    public ProdutoDAO() throws Exception{
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Produto oProduto = (Produto) objeto;
            Boolean retorno = false;
                if (oProduto.getId_Produto()== 0) {
                    retorno = this.inserir(oProduto);
                } else {
                    retorno = this.alterar(oProduto);
                }
                  return retorno;    
    }

    @Override
    public Boolean inserir(Object objeto) {
        Produto oProduto = (Produto) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into Produto (nome_Produto, ultimoPrecoPago, saldoAtual, id_TipoProduto, id_unidadeMedida)"
                + "values(?,?,?,?,?)";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oProduto.getNome_Produto());
            stmt.setInt(2, oProduto.getUltimoPrecoPago());
            stmt.setInt(3, oProduto.getSaldoAtual());
            stmt.setInt(4, oProduto.getId_TipoProduto().getId_TipoProduto());
            stmt.setInt(5, oProduto.getId_unidadeMedida().getId_unidadeMedida());
            stmt.execute();
            conexao.commit();
            return true;
        }catch(Exception ex){
            try{
                System.out.println("Problemas ao cadastrar o Produto: "+ex.getMessage());
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
    Produto oProduto = (Produto) objeto;
        PreparedStatement stmt = null;
        String sql = "update Produto set nome_Produto=?,ultimoPrecoPago=?, saldoAtual=?, id_TipoProduto=?, id_unidadeMedida=?"
                + "where id_Produto=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oProduto.getNome_Produto());
            stmt.setInt(2, oProduto.getUltimoPrecoPago());
            stmt.setInt(3, oProduto.getSaldoAtual());
            stmt.setInt(4, oProduto.getId_TipoProduto().getId_TipoProduto());
            stmt.setInt(5, oProduto.getId_unidadeMedida().getId_unidadeMedida());
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception ex){
            try{
                System.out.println("Problemas ao alterar o Produto! Erro:");
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
        int id_Produto = numero;
            PreparedStatement stmt = null;
        
            String sql = "delete from Produto where id_Produto=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id_Produto);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex){
            System.out.println("Problemas ao excluir o Produto! Erro: "
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
    int id_Produto = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Produto oProduto = null;
        String sql = "select * from Produto where id_Produto=?";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id_Produto);
            rs=stmt.executeQuery();
            while (rs.next()) {
                oProduto = new Produto();
                oProduto.setId_Produto(rs.getInt("id_Produto"));
                oProduto.setNome_Produto(rs.getString("nome_Produto"));
                oProduto.setUltimoPrecoPago(rs.getInt("ultimoPrecoPago"));
                oProduto.setSaldoAtual(rs.getInt("saldoAtual"));
                
                TipoProdutoDAO oTipoProdutoDAO = new TipoProdutoDAO();
                oProduto.setId_TipoProduto((TipoProduto) oTipoProdutoDAO.carregar(rs.getInt("id_TipoProduto")));
                
                UnidadeMedidaDAO oUnidadeMedidaDAO = new UnidadeMedidaDAO();
                oProduto.setId_unidadeMedida((UnidadeMedida) oUnidadeMedidaDAO.carregar(rs.getInt("id_unidadeMedida")));
            }
            return oProduto;
        } catch (Exception ex){
            System.out.println("Problemas ao carregar Produto!"+ex.getMessage());
            return false;
        }     
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from Produto order by id_Produto";
        try{
            stmt = conexao.prepareStatement(sql);
            rs=stmt.executeQuery();
            while (rs.next()){
                Produto oProduto = new Produto();
                oProduto.setId_Produto(rs.getInt("id_Produto"));
                oProduto.setNome_Produto(rs.getString("nome_Produto"));
                oProduto.setUltimoPrecoPago(rs.getInt("ultimoPrecoPago"));
                oProduto.setSaldoAtual(rs.getInt("saldoAtual"));
                
                
                TipoProdutoDAO oTipoProdutoDAO = null;
                try{
                    oTipoProdutoDAO = new TipoProdutoDAO();
                }catch (Exception ex){
                    System.out.println("Erro buscar Produto"+ex.getMessage());
                    ex.printStackTrace();
                }
                oProduto.setId_TipoProduto((TipoProduto) oTipoProdutoDAO.carregar(rs.getInt("id_TipoProduto")));
                
                UnidadeMedidaDAO oUnidadeMedidaDAO = null;
                try{
                    oUnidadeMedidaDAO = new UnidadeMedidaDAO();
                }catch (Exception ex){
                    System.out.println("Erro buscar Produto"+ex.getMessage());
                    ex.printStackTrace();
                }
                oProduto.setId_unidadeMedida((UnidadeMedida) oUnidadeMedidaDAO.carregar(rs.getInt("id_unidadeMedida")));
            }
        }catch(SQLException ex){
            System.out.println("Problemas ao listar Produto! Erro: " +ex.getMessage());
        }
        return resultado;    
    }
    
}
