package br.com.masterserv.ligth_stock.controller;

/*
 * @author JFreitas - created on 29/11/2020
 */

import br.com.masterserv.ligth_stock.entity.Produto;
import br.com.masterserv.ligth_stock.repository.ProdutoRepository;
import br.com.masterserv.ligth_stock.service.ProdutoService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/produto") // A URI seria "http://localhost:8084/light_stock/produto".
@CrossOrigin
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepo;

    @PostMapping(value = "/novo")
    @JsonView(View.ProdutoCompleto.class)
    public Produto cadastrarProduto(@RequestBody ProdutoDTO produto){
        return produtoService.adicionarProduto(
                produto.getProdutoCodigoVenda(),
                produto.getProdutoCodigoComprado(),
                produto.getProdutoNome(),
                produto.getProdutoNcm(),
                produto.getProdutoUnidade(),
                produto.getProdutoQuantidade(),
                produto.getProdutoPrecoCompra(),
                produto.getProdutoPercentagemLucro(),
                produto.getProdutoPrecoVenda(),
                produto.getProdutoPrecoFobUsa(),
                produto.getProdutoPesoKg(),
                produto.getProdutoDimensaoCm(),
                produto.getUsuario());
    }

    @GetMapping(value = "/busca/{responsavel}")
    @JsonView(View.ProdutoCompleto.class)
    public List<Produto> buscarPorResponsavel(
            @PathVariable("responsavel") String responsavel){
        return produtoRepo.findByResponsavelNomeOrResponsavelEmail(responsavel, responsavel);
    }
}
