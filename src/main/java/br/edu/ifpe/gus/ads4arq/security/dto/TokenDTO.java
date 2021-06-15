package br.edu.ifpe.gus.ads4arq.security.dto;

//Json Web Token (JWT): https://datatracker.ietf.org/doc/html/rfc7519
public class TokenDTO {

	private String token;
	private String tipoAutorizacao;

	public TokenDTO(String token, String tipoAutorizacao) {
		this.token = token;
		this.tipoAutorizacao = tipoAutorizacao;

	}

	public String getTipoAutorizacao() {
		return tipoAutorizacao;
	}

	public String getToken() {
		return token;
	}

}
