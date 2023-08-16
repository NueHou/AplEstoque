/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.model;

/**
 *
 * @author 55179
 */
public class Produto {
    private int id_Produto;
    private String nome_Produto;
    private int ultimoPrecoPago;
    private int saldoAtual;
    private TipoProduto id_TipoProduto;
    private UnidadeMedida id_unidadeMedida;

    public Produto() {
        this.id_Produto = 0;
        this.nome_Produto = "";
        this.ultimoPrecoPago = 0;
        this.saldoAtual = 0;
        this.id_TipoProduto = new TipoProduto();
        this.id_unidadeMedida = new UnidadeMedida();
    }

    public Produto(int id_Produto, String nome_Produto, int ultimoPrecoPago, int saldoAtual, TipoProduto id_TipoProduto, UnidadeMedida id_unidadeMedida) {
        this.id_Produto = id_Produto;
        this.nome_Produto = nome_Produto;
        this.ultimoPrecoPago = ultimoPrecoPago;
        this.saldoAtual = saldoAtual;
        this.id_TipoProduto = id_TipoProduto;
        this.id_unidadeMedida = id_unidadeMedida;
    }

    public Produto(int id_Produto, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId_Produto() {
        return id_Produto;
    }

    public void setId_Produto(int id_Produto) {
        this.id_Produto = id_Produto;
    }

    public String getNome_Produto() {
        return nome_Produto;
    }

    public void setNome_Produto(String nome_Produto) {
        this.nome_Produto = nome_Produto;
    }

    public int getUltimoPrecoPago() {
        return ultimoPrecoPago;
    }

    public void setUltimoPrecoPago(int ultimoPrecoPago) {
        this.ultimoPrecoPago = ultimoPrecoPago;
    }

    public int getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(int saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public TipoProduto getId_TipoProduto() {
        return id_TipoProduto;
    }

    public void setId_TipoProduto(TipoProduto id_TipoProduto) {
        this.id_TipoProduto = id_TipoProduto;
    }

    public UnidadeMedida getId_unidadeMedida() {
        return id_unidadeMedida;
    }

    public void setId_unidadeMedida(UnidadeMedida id_unidadeMedida) {
        this.id_unidadeMedida = id_unidadeMedida;
    }

    
   
}
