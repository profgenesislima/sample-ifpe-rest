package br.edu.ifpe.gus.ads4arq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpe.gus.ads4arq.entity.Categoria;
import br.edu.ifpe.gus.ads4arq.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	public Categoria  findByNome(String nome){
		return categoriaRepository.findByNome(nome);	
	}	
	
}
