package br.com.masterserv.ligth_stock.entity;

/*
 * @author JFreitas - created on 20/11/2020
 */

import javax.persistence.*;

@Entity
@Table(name = "autorizacao")
public class Autorizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aut_id")
    private Long id;

    // Nome é o tipo de autorização ou nínel de acesso.
    @Column(name = "aut_nome", unique = true, length = 20, nullable = false)
    private String nome;

    // Essa classe não tem relacionamentos, pois os relacionamentos já foram mapeados na
    // classe usuário, não precisando ser mapeada dos dois lados do relacionamento


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
}