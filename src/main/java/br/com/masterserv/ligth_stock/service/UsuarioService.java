package br.com.masterserv.ligth_stock.service;

/*
 * @author JFreitas - created on 25/11/2020
 */

import br.com.masterserv.ligth_stock.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService extends UserDetailsService {

    // Aqui definimos todos os métodos que o usuário possui.

    public Usuario novoUsuario(String nome, String email,
                               String senha, String autorizacao);
}