package br.com.masterserv.ligth_stock.security;

/*
 * @author JFreitas - created on 21/12/2020
 */

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        try {
            HttpServletRequest servletRequest = (HttpServletRequest) request;
            String authorization = servletRequest
                    .getHeader(HttpHeaders.AUTHORIZATION);

            if (authorization != null) {
                User usuario = JwtUtils
                        .parseToken(authorization.replaceAll("Bearer ", ""));
                Authentication credentials =
                        new UsernamePasswordAuthenticationToken(
                                usuario.getUsername(),
                                usuario.getPassword(),
                                usuario.getAuthorities());
                SecurityContextHolder.getContext()
                        .setAuthentication(credentials);
            }

            chain.doFilter(request, response);
        }

        catch(Throwable t) {
            HttpServletResponse servletResponse =
                    (HttpServletResponse) response;
            servletResponse.sendError(
                    HttpServletResponse.SC_UNAUTHORIZED, t.getMessage());

            // jff
            throw new IOException(
                    "Usuário não logado ou expirado / corrompido");
        }
    }
}
