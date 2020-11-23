package br.com.masterserv.ligth_stock.entity;

/*
 * @author JFreitas - created on 20/11/2020
 */

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private Long id;

    @Column(name = "prod_cod_venda", unique=true, length = 15, nullable = false)
    private String produtoCodigoVenda; // Código do produto interno da Empresa, NFe saida

    @Column(name = "prod_cod_entrada", unique=true, length = 15, nullable = false)
    private String produtoCodigoComprado; // Código do produto que veio na NFe entrada

    @Column(name = "prod_nome", length = 250, nullable = false)
    private String produtoNome;

    @Column(name = "prod_ncm", length = 8, nullable = false)
    private int produtoNcm;

    // Unidade da disponibilidade do produto, pode ser
    // UN = unidade, KG = Kilograma, PC = Pacote, etc.
    @Column(name = "prod_unidade", length = 10, nullable = false)
    private String produtoUnidade;

    @Column(name = "prod_quantidade", length = 10, nullable = false)
    private int produtoQuantidade;

    @Column(name = "prod_preco_compra", precision=8, scale=2, nullable = false)
    private BigDecimal produtoPrecoCompra;

    @Column(name = "prod_perc_lucro", precision=3, scale=1, nullable = false)
    private BigDecimal produtoPercentagemLucro;

    @Column(name = "prod_preco_venda", precision=9, scale=2, nullable = false)
    private BigDecimal produtoPrecoVenda;

    // Preço do produto em dolar americano FOB USA.
    @Column(name = "prod_preco_fob_usa", precision=8, scale=2)
    private BigDecimal produtoPrecoFobUsa;

    @Column(name = "prod_peso_kg", precision=6, scale=3)
    private BigDecimal produtoPesoKg;

    @Column(name = "prod_dimensao_cm", length = 15)
    private String produtoDimensaoCm;

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

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }
}
