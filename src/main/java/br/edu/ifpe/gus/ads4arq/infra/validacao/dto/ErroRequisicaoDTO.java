package br.edu.ifpe.gus.ads4arq.infra.validacao.dto;

public class ErroRequisicaoDTO {

	private String erro;
	private String descricao;
	
	public ErroRequisicaoDTO(String erro, String descricao) {
		super();
		this.erro = erro;
		this.descricao = descricao;
	}

	public String getErro() {
		return erro;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	
	
}
