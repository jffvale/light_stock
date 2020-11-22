package br.com.masterserv.ligth_stock.repository;

/*
 * @author JFreitas - created on 21/11/2020
 */

import br.com.masterserv.ligth_stock.entity.Autorizacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {

    public Autorizacao findByNome(String nome);

}
