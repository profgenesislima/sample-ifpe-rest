package br.edu.ifpe.gus.ads4arq.dto;

import br.edu.ifpe.gus.ads4arq.entity.Produto;
import br.edu.ifpe.gus.ads4arq.infra.Mapper;

public class ProdutoViewMapper implements Mapper<Produto, ProdutoView>{

	@Override
	public ProdutoView map(Produto source) {
		
		return new ProdutoView(source);
	}

}
