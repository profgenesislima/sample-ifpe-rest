package br.edu.ifpe.gus.ads4arq.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpe.gus.ads4arq.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findByCategoria_Nome(String nome);

}
