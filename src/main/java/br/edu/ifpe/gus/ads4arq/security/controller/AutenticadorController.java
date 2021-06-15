package br.edu.ifpe.gus.ads4arq.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifpe.gus.ads4arq.security.dto.LoginForm;
import br.edu.ifpe.gus.ads4arq.security.dto.TokenDTO;
import br.edu.ifpe.gus.ads4arq.security.service.TokenService;

/*
 * O JWT e OAuth2 são as soluções mais implementadas para autenticação e autorização de Api's. O que você deve saber do JWT:

Oferecem uma maneira estruturada e stateless de guardar informações de autorização de um usuário.
Permite que a aplicação client guarde as permissões do usuário.
Podem ser encriptados e cryptographically signed para evitar adulterações.
Podem escalar horizontalmente.
Possibilita criar serviços verdadeiramente RESTful.
Expiração interna.
São independentes.
*/




@Controller
@RequestMapping("autenticador")
public class AutenticadorController {

	
	
	@Autowired
	AuthenticationManager autenticador;
	
	@Autowired
	TokenService tokenService;
	
	
	@PostMapping
	public ResponseEntity<TokenDTO> autentica(@RequestBody LoginForm loginForm){
		UsernamePasswordAuthenticationToken credenciais = loginForm.converte();
		try {
			Authentication autenticacao = autenticador.authenticate(credenciais);
			String token = tokenService.gerarToken(autenticacao);
			System.out.println("TOKEN - Controller "+token);
			return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
			
		} catch (AuthenticationException e) {
        return ResponseEntity.badRequest().build();
}
	}
}
