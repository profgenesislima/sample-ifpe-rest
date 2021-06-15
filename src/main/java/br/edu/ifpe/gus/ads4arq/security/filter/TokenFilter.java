package br.edu.ifpe.gus.ads4arq.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.edu.ifpe.gus.ads4arq.security.entity.Usuario;
import br.edu.ifpe.gus.ads4arq.security.repository.UsuarioRepository;
import br.edu.ifpe.gus.ads4arq.security.service.TokenService;

public class TokenFilter extends OncePerRequestFilter{
	
	private final String tipoAutenticacao = "Bearer ";
	
	private TokenService tokenService;
	@Autowired
	private UsuarioRepository repository;
	
	
	

	public TokenFilter(TokenService tokenService, UsuarioRepository repository) {
		super();
		this.tokenService = tokenService;
		this.repository = repository;
	}




	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		var requestToken = request.getHeader("Authorization");
		String authorizationToken = null;
		
		
		if(requestToken!= null)
			if(!requestToken.isEmpty() || requestToken.startsWith(tipoAutenticacao)) {
				authorizationToken = requestToken.substring(7, requestToken.length());
			}

		boolean tokenEhValido = tokenService.tokenValido(authorizationToken);
		
		if(tokenEhValido)
			autentica(authorizationToken);
	
		
		filterChain.doFilter(request, response);
		
	}
	
	private void autentica(String token) {
		Long idUsuario = tokenService.getIdUsuario(token);
		Usuario usuario = repository.findById(idUsuario).get();
		UsernamePasswordAuthenticationToken credenciais = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(credenciais);
	}
	

}
