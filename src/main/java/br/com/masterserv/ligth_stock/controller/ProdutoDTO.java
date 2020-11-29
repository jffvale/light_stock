package br.com.masterserv.ligth_stock.controller;

/*
 * @author JFreitas - created on 29/11/2020
 */

import java.math.BigDecimal;

public class ProdutoDTO {
    private String produtoCodigoVenda;
    private String produtoCodigoComprado;
    private String produtoNome;
    private int produtoNcm;
    private String produtoUnidade;
    private int produtoQuantidade;
    private BigDecimal produtoPrecoCompra;
    private BigDecimal produtoPercentagemLucro;
    private BigDecimal produtoPrecoVenda;
    private BigDecimal produtoPrecoFobUsa;
    private BigDecimal produtoPesoKg;
    private String produtoDimensaoCm;
    private String usuario; // responsavel pela operação

    public String getProdutoCodigoVenda() {
        return produtoCodigoVenda;
    }

    public void setProdutoCodigoVenda(String produtoCodigoVenda) {
        this.produtoCodigoVenda = produtoCodigoVenda;
    }

    public String getProdutoCodigoComprado() {
        return produtoCodigoComprado;
    }

    public void setProdutoCodigoComprado(String produtoCodigoComprado) {
        this.produtoCodigoComprado = produtoCodigoComprado;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public int getProdutoNcm() {
        return produtoNcm;
    }

    public void setProdutoNcm(int produtoNcm) {
        this.produtoNcm = produtoNcm;
    }

    public String getProdutoUnidade() {
        return produtoUnidade;
    }

    public void setProdutoUnidade(String produtoUnidade) {
        this.produtoUnidade = produtoUnidade;
    }

    public int getProdutoQuantidade() {
        return produtoQuantidade;
    }

    public void setProdutoQuantidade(int produtoQuantidade) {
        this.produtoQuantidade = produtoQuantidade;
    }

    public BigDecimal getProdutoPrecoCompra() {
        return produtoPrecoCompra;
    }

    public void setProdutoPrecoCompra(BigDecimal produtoPrecoCompra) {
        this.produtoPrecoCompra = produtoPrecoCompra;
    }

    public BigDecimal getProdutoPercentagemLucro() {
        return produtoPercentagemLucro;
    }

    public void setProdutoPercentagemLucro(BigDecimal produtoPercentagemLucro) {
        this.produtoPercentagemLucro = produtoPercentagemLucro;
    }

    public BigDecimal getProdutoPrecoVenda() {
        return produtoPrecoVenda;
    }

    public void setProdutoPrecoVenda(BigDecimal produtoPrecoVenda) {
        this.produtoPrecoVenda = produtoPrecoVenda;
    }

    public BigDecimal getProdutoPrecoFobUsa() {
        return produtoPrecoFobUsa;
    }

    public void setProdutoPrecoFobUsa(BigDecimal produtoPrecoFobUsa) {
        this.produtoPrecoFobUsa = produtoPrecoFobUsa;
    }

    public BigDecimal getProdutoPesoKg() {
        return produtoPesoKg;
    }

    public void setProdutoPesoKg(BigDecimal produtoPesoKg) {
        this.produtoPesoKg = produtoPesoKg;
    }

    public String getProdutoDimensaoCm() {
        return produtoDimensaoCm;
    }

    public void setProdutoDimensaoCm(String produtoDimensaoCm) {
        this.produtoDimensaoCm = produtoDimensaoCm;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
