package br.com.masterserv.ligth_stock.repository;

/*
 * @author JFreitas - created on 21/11/2020
 */

import br.com.masterserv.ligth_stock.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @PreAuthorize("isAuthenticated()")
    public List<Produto> findByResponsavelNomeOrResponsavelEmail (String nome, String email);

}
