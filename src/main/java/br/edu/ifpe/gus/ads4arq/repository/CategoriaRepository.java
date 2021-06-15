package br.edu.ifpe.gus.ads4arq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpe.gus.ads4arq.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	Categoria findByNome(String nome);
	
}
