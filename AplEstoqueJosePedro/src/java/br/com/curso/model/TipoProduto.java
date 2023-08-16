/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.model;
/**
 *
 * @author 55179
 */
public class TipoProduto {
    private int id_TipoProduto;
    private String descricao;

    public TipoProduto() {
        this.id_TipoProduto = 0;
        this.descricao = "";
    }

    public TipoProduto(int id_TipoProduto, String descricao) {
        this.id_TipoProduto = id_TipoProduto;
        this.descricao = descricao;
    }

    public int getId_TipoProduto() {
        return id_TipoProduto;
    }

    public void setId_TipoProduto(int id_TipoProduto) {
        this.id_TipoProduto = id_TipoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
