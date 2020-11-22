package br.com.masterserv.ligth_stock.repository;

/*
 * @author JFreitas - created on 21/11/2020
 */

import br.com.masterserv.ligth_stock.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByResponsavelNomeOrResponsavelEmail (String nome, String email);

}
