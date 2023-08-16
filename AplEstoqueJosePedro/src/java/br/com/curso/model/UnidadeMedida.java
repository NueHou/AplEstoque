/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.model;

/**
 *
 * @author 55179
 */
public class UnidadeMedida {
    private int id_unidadeMedida;
    private String descricao;
    private String sigla;
    

    public UnidadeMedida() {
        this.id_unidadeMedida = 0;
        this.descricao = "";
        this.sigla = "";
    }

    public UnidadeMedida(int id_unidadeMedida, String descricao, String sigla) {
        this.id_unidadeMedida = id_unidadeMedida;
        this.descricao = descricao;
        this.sigla = sigla;
    }

    public int getId_unidadeMedida() {
        return id_unidadeMedida;
    }

    public void setId_unidadeMedida(int id_unidadeMedida) {
        this.id_unidadeMedida = id_unidadeMedida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }


   
    
}
