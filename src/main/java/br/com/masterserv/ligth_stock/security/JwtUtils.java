package br.com.masterserv.ligth_stock.security;

/*
 * @author JFreitas - created on 21/12/2020
 */

import br.com.masterserv.ligth_stock.controller.UsuarioDTO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.User;
import java.io.IOException;
import java.util.Date;

// Métodos para criar e validar o token.
public class JwtUtils {

    private static final String KEY = "spring.jwt.sec";

    public static String generateToken(User usuario) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        UsuarioDTO usuarioSemSenha = new UsuarioDTO();
        usuarioSemSenha.setNome(usuario.getUsername());

        if(!usuario.getAuthorities().isEmpty()) {
            usuarioSemSenha.setAutorizacao(
                    usuario.getAuthorities().iterator()
                            .next().getAuthority());
        }

        String usuarioJson = mapper.writeValueAsString(usuarioSemSenha);
        Date agora = new Date();
        Long hora = 1000L * 60L * 60L; // Uma hora
        return Jwts.builder().claim("userDetails", usuarioJson)
                .setIssuer("br.com.masterserv")
                .setSubject(usuario.getUsername())
                .setExpiration(new Date(agora.getTime() + hora))
                .signWith(SignatureAlgorithm.HS512, KEY)
                .compact();
    }

    public static User parseToken(String token)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        String credentialsJson = Jwts.parser()
                .setSigningKey(KEY)
                .parseClaimsJws(token)
                .getBody()
                .get("userDetails", String.class);
        UsuarioDTO usuario = mapper
                .readValue(credentialsJson, UsuarioDTO.class);

        return (User) User.builder().username(usuario.getNome())
                .password("secret")
                .authorities(usuario.getAutorizacao())
                .build();
    }
}