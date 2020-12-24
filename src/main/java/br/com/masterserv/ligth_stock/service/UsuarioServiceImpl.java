package br.com.masterserv.ligth_stock.service;

/*
 * @author JFreitas - created on 25/11/2020
 */

import br.com.masterserv.ligth_stock.entity.Autorizacao;
import br.com.masterserv.ligth_stock.entity.Usuario;
import br.com.masterserv.ligth_stock.repository.AutorizacaoRepository;
import br.com.masterserv.ligth_stock.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashSet;
import java.util.stream.Collectors;
import org.springframework.transaction.TransactionException;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private AutorizacaoRepository autorizacaoRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

	@Autowired
	private PasswordEncoder passEncoder;

    @Override
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Usuario novoUsuario(String nome, String email, String senha,
                               String autorizacao) {
        Autorizacao aut = autorizacaoRepo.findByNome(autorizacao);

        if(aut == null) {
            aut = new Autorizacao();
            aut.setNome(autorizacao);
            autorizacaoRepo.save(aut);
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(passEncoder.encode(senha)); //passEncoder.encode(senha)
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        usuario.getAutorizacoes().add(aut);

        try { // JFF Obtendo o erro de integridade BD

            usuarioRepo.save(usuario);

        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            System.out.printf("%n%n%n");
            throw new RuntimeException("\n\nUsuario solicitado não pode ser cadastrado." +
                    "\nUSUARIO JÁ EXISTE!!! (Nome e/ou email)\n\n");
        } catch (TransactionException ex){
            System.out.println("\n\n\n+++++++++++\n\n\n");
        }

        return usuario;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Usuario usuario =
                usuarioRepo.findTop1ByNomeOrEmail(
                        username, username);
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuário "
                    + username
                    + " não encontrado");
        }
        return User.builder().username(username)
                .password(usuario.getSenha())
                .authorities(usuario.getAutorizacoes()
                        .stream()
                        .map(Autorizacao::getNome)
                        .collect(Collectors.toList())
                        .toArray(new String[usuario
                                .getAutorizacoes()
                                .size()]))
                .build();
    }
}