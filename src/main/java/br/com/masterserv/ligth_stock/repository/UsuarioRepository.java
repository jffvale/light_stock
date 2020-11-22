package br.com.masterserv.ligth_stock.repository;

/*
 * @author JFreitas - created on 21/11/2020
 */

import br.com.masterserv.ligth_stock.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findTop1ByNomeOrEmail(String nome, String email);

}
