/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.model;

/**
 *
 * @author 55179
 */
public class MovimentoEstoque {
    private int idMovimento;
    private String entradaSaida;
    private String documento;
    private String data;
    private int quantidade;
    private double valorMovimento;
    private Produto id_Produto;
    private TipoMovimento idTipoMovimento;
    private Funcionario idFuncionario;

    public MovimentoEstoque() {
        this.idMovimento = 0;
        this.entradaSaida = "";
        this.documento = "";
        this.data = "";
        this.quantidade = 0;
        this.valorMovimento = 0;
        this.id_Produto = new Produto();
        this.idTipoMovimento = new TipoMovimento();
        this.idFuncionario = new Funcionario();
    }

    public MovimentoEstoque(int idMovimento, String entradaSaida, String documento, String data, int quantidade, double valorMovimento, Produto id_Produto, TipoMovimento idTipoMovimento, Funcionario idFuncionario) {
        this.idMovimento = idMovimento;
        this.entradaSaida = entradaSaida;
        this.documento = documento;
        this.data = data;
        this.quantidade = quantidade;
        this.valorMovimento = valorMovimento;
        this.id_Produto = id_Produto;
        this.idTipoMovimento = idTipoMovimento;
        this.idFuncionario = idFuncionario;
    }

    public int getIdMovimento() {
        return idMovimento;
    }

    public void setIdMovimento(int idMovimento) {
        this.idMovimento = idMovimento;
    }

    public String getEntradaSaida() {
        return entradaSaida;
    }

    public void setEntradaSaida(String entradaSaida) {
        this.entradaSaida = entradaSaida;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorMovimento() {
        return valorMovimento;
    }

    public void setValorMovimento(double valorMovimento) {
        this.valorMovimento = valorMovimento;
    }

    public Produto getId_Produto() {
        return id_Produto;
    }

    public void setId_Produto(Produto id_Produto) {
        this.id_Produto = id_Produto;
    }

    public TipoMovimento getIdTipoMovimento() {
        return idTipoMovimento;
    }

    public void setIdTipoMovimento(TipoMovimento idTipoMovimento) {
        this.idTipoMovimento = idTipoMovimento;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

}
