package br.com.masterserv.ligth_stock.controller;

/*
 * @author JFreitas - created on 28/11/2020
 */

public class UsuarioDTO {

    // Informações que virão em formato JSON no corpo da requisição (@RequestBody).
    private String nome;
    private String email;
    private String senha;
    private String autorizacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAutorizacao() {
        return autorizacao;
    }

    public void setAutorizacao(String autorizacao) {
        this.autorizacao = autorizacao;
    }
}
