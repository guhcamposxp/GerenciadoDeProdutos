package br.senac.tads.gerenciador.produto;

import java.util.Date;

public class Produto {

    private String nome;
    private String descricao;
    private String valorCompra;
    private String valorVenda;
    private String categorias;
    private Date data;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(String valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
