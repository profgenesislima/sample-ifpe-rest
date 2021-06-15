package br.edu.ifpe.gus.ads4arq.dto;

import br.edu.ifpe.gus.ads4arq.entity.Categoria;
import br.edu.ifpe.gus.ads4arq.entity.Produto;
import br.edu.ifpe.gus.ads4arq.infra.Mapper;
//Tratar categoria para registrar no banco de dados
public class ProdutoFormMapper implements Mapper<ProdutoForm, Produto>{

	@Override
	public Produto map(ProdutoForm source) {
	
		return new Produto(source.getNome(),source.getDescricao(),source.getPreco(), new Categoria(source.getCategoriaNome()));
	}

}
