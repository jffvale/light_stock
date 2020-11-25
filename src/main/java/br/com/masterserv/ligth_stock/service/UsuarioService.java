package br.com.masterserv.ligth_stock.service;

/*
 * @author JFreitas - created on 25/11/2020
 */

import br.com.masterserv.ligth_stock.entity.Usuario;

public interface UsuarioService {

    // Aqui definimos todos os métodos que o usuário possui.

    public Usuario novoUsuario(String nome, String email, String senha, String autorizacao);

}
