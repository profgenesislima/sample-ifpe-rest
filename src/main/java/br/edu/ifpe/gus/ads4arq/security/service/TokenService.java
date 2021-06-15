package br.edu.ifpe.gus.ads4arq.security.service;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.edu.ifpe.gus.ads4arq.security.entity.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	
	@Value("${ifpe.jwt.expira_em}")
	private String expiraEm;
	
	@Value("${ifpe.jwt.token_hash}")
	private String hashDoToken;
	
	
	public String gerarToken(Authentication autenticacao) {
		Usuario usuarioLogado = (Usuario) autenticacao.getPrincipal();
		Date dataAtual = java.sql.Date.valueOf(LocalDate.now());
		Date dataExpiracao =  new Date(dataAtual.getTime() + Long.parseLong(expiraEm)) ;
		 return Jwts.builder()
				 .setIssuer("IFPE - Vendas")
				 .setIssuedAt(dataAtual)
				 .setSubject(usuarioLogado.getId().toString())
				 .setExpiration(dataExpiracao)
				 .signWith(SignatureAlgorithm.HS256,hashDoToken)
				 .compact();
				 
	}

	public boolean tokenValido(String authorizationToken) {
		try {
//			System.out.println("METODO TOKEN VALIDO \n" + authorizationToken+"\n");
			Jwts.parser().setSigningKey(this.hashDoToken).parseClaimsJws(authorizationToken);
			return true;
			
		} catch (Exception e) {
//			System.out.println("ERRO: "+e.getMessage());
			return false;
		}
	}
	
	
	public Long getIdUsuario(String authorizationToken) {
		return Long.parseLong(Jwts.parser().setSigningKey(this.hashDoToken).parseClaimsJws(authorizationToken).getBody().getSubject());
		
	}
}
