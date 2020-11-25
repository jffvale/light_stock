package br.com.masterserv.ligth_stock.service;

/*
 * @author JFreitas - created on 25/11/2020
 */

import br.com.masterserv.ligth_stock.entity.Produto;

import java.math.BigDecimal;

public interface ProdutoService {

    // Aqui definimos todos os métodos que Produto necessita. Aqui é só a chamada do metodo
    // ele está implementado na classe NOME_INTERFACE_IMPL (ProdutoServiceImpl).

    public Produto adicionarProduto(
            String produtoCodigoVenda,
            String produtoCodigoComprado,
            String produtoNome,
            int produtoNcm,
            String produtoUnidade,
            int produtoQuantidade,
            BigDecimal produtoPrecoCompra,
            BigDecimal produtoPercentagemLucro,
            BigDecimal produtoPrecoVenda,
            BigDecimal produtoPrecoFobUsa,
            BigDecimal produtoPesoKg,
            String produtoDimensaoCm,
            String responsavel);
}
