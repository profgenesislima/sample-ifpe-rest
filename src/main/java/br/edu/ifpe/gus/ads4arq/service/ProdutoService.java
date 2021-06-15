package br.edu.ifpe.gus.ads4arq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.ifpe.gus.ads4arq.entity.Produto;
import br.edu.ifpe.gus.ads4arq.repository.ProdutoRepository;

@Service
public class ProdutoService {

	
	@Autowired
	private ProdutoRepository repository;
	
	public void salvar(Produto produto) {
		repository.save(produto);
	}
	
	public List<Produto> findAll(){
		return repository.findAll();
	}
	
	public Page<Produto> findAll(Pageable paginacao){
		return repository.findAll(paginacao);
	}
	
	public List<Produto> findByCategoriaNome(String nomeCategoria){
		return repository.findByCategoria_Nome(nomeCategoria);
	}
	


	public Produto findById(Long id) {
		return repository.getOne(id);
	}

	public Produto atualizar(Produto oldProduto, CategoriaService categoriaService) {
		Produto produto = repository.getOne(oldProduto.getId());
		
		produto.setNome(oldProduto.getNome());
		produto.setDescricao(oldProduto.getDescricao());
		produto.setPreco(oldProduto.getPreco());
		
		var categoria = categoriaService.findByNome(oldProduto.getCategoria().getNome());
		
		produto.setCategoria(categoria);
		return produto;
	}
	
	public void removePorId(Long id) {
		repository.deleteById(id);
	}
}
