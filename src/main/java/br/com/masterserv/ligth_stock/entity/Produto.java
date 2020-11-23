package br.com.masterserv.ligth_stock.entity;

/*
 * @author JFreitas - created on 20/11/2020
 */

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private Long id;

    @Column(name = "prod_cod_venda", unique=true, length = 15, nullable = false)
    private String produtoCodigoVenda; // Codigo produto da empresa, para venda.

    @Column(name = "prod_cod_entrada", length = 15, nullable = false)
    private String produtoCodigoComprado; // Codigo produto que consta na NFe de compra.

    @Column(name = "prod_nome", length = 250, nullable = false)
    private String produtoNome;


    @ManyToOne(fetch = FetchType.EAGER) // "EAGER" significa que toda vez que buscar uma
    // frase ela trás o autor, ao contrário do "LAZY"

    // A chave estrangeira é mapeada com a anotação @JoinColumn.
    @JoinColumn(name = "usr_resp_id") // É o nome da coluna que tem a Chave estrangeira.
    private Usuario responsavel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }
}
