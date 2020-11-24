package br.com.masterserv.ligth_stock;

import br.com.masterserv.ligth_stock.entity.Produto;
import br.com.masterserv.ligth_stock.entity.Usuario;
import br.com.masterserv.ligth_stock.repository.ProdutoRepository;
import br.com.masterserv.ligth_stock.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional // Habilitar o acesso ao BD e transações - do Spring (javax).
@Rollback	   // Limpar o BD após os testes - do Spring.
class LigthStockApplicationTests {

	// Injetando, o autowired dá o "new". Assim quando usar 2 usuários abaixo não
	// dará nullpoint.
	@Autowired
	private UsuarioRepository usuarioRepo;

	@Autowired
	private ProdutoRepository produtoRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void usuarioRepositorySaveTest(){
		Usuario usuario = new Usuario();
		usuario.setNome("Joao");
		usuario.setEmail("test@email.com");
		usuario.setSenha("senha");

		usuarioRepo.save(usuario);

		// Checando se o ID não é  nulo, pois deve ter sido gerado automaticamente.
		assertNotNull(usuario.getId());
	}

	@Test
	void produtoRepositorySaveTest(){
		Usuario usuario = new Usuario();
		usuario.setNome("Joao");
		usuario.setEmail("test@email.com");
		usuario.setSenha("senha");

		usuarioRepo.save(usuario);

		Produto produto = new Produto();
		produto.setProdutoCodigoVenda("12345678br");
		produto.setProdutoCodigoComprado("Test test");
		produto.setProdutoNome("Caneta bic");
		produto.setProdutoNcm(12345678);
		produto.setProdutoUnidade("pacote");
		produto.setProdutoQuantidade(15);
		produto.setProdutoPrecoCompra(new BigDecimal(15.20));
		produto.setProdutoPercentagemLucro(new BigDecimal(25.8));
		produto.setProdutoPrecoVenda(new BigDecimal(25.4));
		produto.setProdutoPrecoFobUsa(new BigDecimal(4.4));
		produto.setProdutoPesoKg(new BigDecimal(4.400));
		produto.setProdutoDimensaoCm("10 x 20 x 50");
		produto.setResponsavel(usuario);

		produtoRepo.save(produto);

		// Checando se o ID não é  nulo, pois deve ter sido gerado automaticamente.
		assertNotNull(usuario.getId());
	}
}
