package br.com.masterserv.ligth_stock.service;

/*
 * @author JFreitas - created on 25/11/2020
 */

import br.com.masterserv.ligth_stock.entity.Produto;
import br.com.masterserv.ligth_stock.entity.Usuario;
import br.com.masterserv.ligth_stock.repository.ProdutoRepository;
import br.com.masterserv.ligth_stock.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service("produtoService")
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private ProdutoRepository produtoRepo;

    @Override
    @Transactional
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
            String responsavel) {

        Usuario usuario = usuarioRepo.findTop1ByNomeOrEmail(responsavel, responsavel);
        if(usuario == null){
            throw new UsernameNotFoundException("Usuário com identificador" +
                    responsavel + "não foi encontrado");
        }
        Produto produto = new Produto();
        produto.setProdutoCodigoVenda(produtoCodigoVenda);
        produto.setProdutoCodigoComprado(produtoCodigoComprado);
        produto.setProdutoNome(produtoNome);
        produto.setProdutoNcm(produtoNcm);
        produto.setProdutoUnidade(produtoUnidade);
        produto.setProdutoQuantidade(produtoQuantidade);
        produto.setProdutoPrecoCompra(produtoPrecoCompra);
        produto.setProdutoPercentagemLucro(produtoPercentagemLucro);
        produto.setProdutoPrecoVenda(produtoPrecoVenda);
        produto.setProdutoPrecoFobUsa(produtoPrecoFobUsa);
        produto.setProdutoPesoKg(produtoPesoKg);
        produto.setProdutoDimensaoCm(produtoDimensaoCm);
        produto.setResponsavel(usuario);

        produtoRepo.save(produto);

        return produto;
    }
}
