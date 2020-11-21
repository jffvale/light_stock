package br.com.masterserv.ligth_stock.entity;

/*
 * @author JFreitas - created on 20/11/2020
 */

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "produto2")
public class Produto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "frs_id")
    private Long id;

    @Column(name = "prod_cod_venda", unique=true, length = 100, nullable = false)
    private String produtoCodigoVenda;

    @Column(name = "frs_conteudo", length = 500, nullable = false)
    private String conteudo;

    @Column(name = "frs_data_hora", nullable = false)
    private Date dataHora;

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

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }
}
