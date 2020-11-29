package br.com.masterserv.ligth_stock.security;

/*
 * @author JFreitas - created on 28/11/2020
 */

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity // Realiza a configuração básica de segurança.
@EnableGlobalMethodSecurity(prePostEnabled = true) // Habilita o uso de anotações
                        // (@PreAuthorize e @PostAuthorize) para limitar o acesso a métodos.
// “SecurityConfiguration extends WebSecurityConfigurerAdapter” que é uma classe de
// configuração do Spring Security e alteramos a configuração desabilitando o CSRF
// (Cross-Site Request Forgery).
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable() // this disables session creation on Spring Security
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
