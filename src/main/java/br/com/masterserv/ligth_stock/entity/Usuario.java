package br.com.masterserv.ligth_stock.entity;

/*
 * @author JFreitas - created on 20/11/2020
 */

import br.com.masterserv.ligth_stock.controller.View;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import javax.persistence.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usuario") // A classe 'Usuario' vai corresponder a tabela 'usuario'
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    @JsonView(View.ProdutoCompleto.class)
    private Long id;

    // Os dados da coluna (nome, unique, lenght,etc) não precisam estar aqui,
    // pois a tabela já foi criada no BD com sua formatação
    // NÃO É RECOMENDADO CRIAR AS TABELAS VIA JPA!
    @Column(name = "usr_nome", unique=true, length = 50, nullable = false)
    @JsonView(View.ProdutoCompleto.class)
    private String nome;

    @Column(name = "usr_email", unique=true, length = 60, nullable = false)
    @JsonView(View.ProdutoCompleto.class)
    private String email;

    @Column(name = "usr_senha", length = 10, nullable = false)
    private String senha;

    // Relacionamentos entre as tabelas
    @ManyToMany(fetch = FetchType.LAZY) // necessita de uma tabela de ligação
    @JoinTable(name = "link_usuario_autorizacao",
            joinColumns = { @JoinColumn(name = "usr_id") },
            inverseJoinColumns = { @JoinColumn(name = "aut_id") })
    private Set<Autorizacao> autorizacoes; // usar o Set, não usar List. Set não tem repetições

    // OO não tem Chave Estrangeira, vc tem o próprio Objeto, no caso Autorizacao.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "responsavel") // Responsável pela compra
    // ou venda de cada produto no estoque da empresa.
    // mappedBY -> Dentro da classe 'Produto' tem um atributo chamado 'responsavel'
    // (linha63) que vai fazer a ligação de 'Produto' com a Classe
    // Lazy -> Quando buscar um Usuario ele so trás as informações produto quando solicitado

    @JsonIgnore // Deve manter esse "ignore" ativo para não deixar o programa em looping.
    private Set<Produto> produtos; // usar o Set, não usar List. Set não tem repetições

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Set<Autorizacao> getAutorizacoes() {
        return autorizacoes;
    }

    public void setAutorizacoes(Set<Autorizacao> autorizacoes) {
        this.autorizacoes = autorizacoes;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
}