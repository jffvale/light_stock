package br.com.masterserv.ligth_stock.controller;

/*
 * @author JFreitas - created on 28/11/2020
 */

import br.com.masterserv.ligth_stock.entity.Usuario;
import br.com.masterserv.ligth_stock.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// A URI base é o local e nome do nosso banco "http://localhost:8084/light_stock"
@RestController
@RequestMapping(value = "/usuario") // A URI seria "http://localhost:8084/light_stock/usuario".
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // @PostMapping – Define que o método a seguir é um serviço que responde a requisições do tipo POST.
    @PostMapping(value = "/novo") // A URI seria "http://localhost:8084/light_stock/usuario/novo".
    public Usuario cadastrarUsuario(@RequestBody UsuarioDTO usuario){

        return usuarioService.novoUsuario(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getAutorizacao());

    }
}
