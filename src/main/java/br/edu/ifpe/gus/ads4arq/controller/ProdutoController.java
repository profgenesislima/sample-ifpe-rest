package br.edu.ifpe.gus.ads4arq.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.ifpe.gus.ads4arq.dto.ProdutoForm;
import br.edu.ifpe.gus.ads4arq.dto.ProdutoFormMapper;
import br.edu.ifpe.gus.ads4arq.dto.ProdutoFormUpdate;
import br.edu.ifpe.gus.ads4arq.dto.ProdutoView;
import br.edu.ifpe.gus.ads4arq.infra.StatusOperacao;
import br.edu.ifpe.gus.ads4arq.service.CategoriaService;
import br.edu.ifpe.gus.ads4arq.service.ProdutoService;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value="/produtos", method=RequestMethod.GET)
	@Cacheable(value="listaDeProdutos")
	public Page<ProdutoView> listarProdutos(@RequestParam(required=false) String nomeCategoria, @RequestParam(required=false) int pagina, 
			@RequestParam(required=false) int quantidade, @RequestParam(required=false) String ordenador){
		
		Pageable paginacao = PageRequest.of(pagina, quantidade, Direction.ASC, ordenador);
		
		if(nomeCategoria !=null)
			return new PageImpl<ProdutoView>(ProdutoView.convert(produtoService.findByCategoriaNome(nomeCategoria)), paginacao, quantidade);
		return ProdutoView.convert(produtoService.findAll(paginacao));
	}
	
	@RequestMapping(value="/produtos", method=RequestMethod.POST)
	@CacheEvict(value = "listaDeProdutos", allEntries = true)
	public ResponseEntity<ProdutoView> cadastrarProduto(@Valid @RequestBody ProdutoForm produtoForm, UriComponentsBuilder uriBuilder) {
		var mapper = new ProdutoFormMapper();
		var produto  = mapper.map(produtoForm);
		produto.setCategoria(categoriaService.findByNome(produtoForm.getCategoriaNome()));
		produtoService.salvar(produto);
		URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getNome()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoView(produto));
	}
	
	@RequestMapping(value="/produtos/{id}", method=RequestMethod.GET)	
	public ProdutoView pegaProdutoPorId(@PathVariable Long id){		
		return ProdutoView.convert(produtoService.findById(id));
	}
	
	@RequestMapping(value = "/produtos/{id}", method = RequestMethod.PUT)
	@CacheEvict(value = "listaDeProdutos", allEntries = true)
	public ResponseEntity<ProdutoView> atualizarProduto(@PathVariable Long id,
			@Valid @RequestBody ProdutoFormUpdate produtoForm, UriComponentsBuilder uriBuilder) {

		var mapper = new ProdutoFormMapper();

		var oldProduto = mapper.map(produtoForm);
		oldProduto.setId(id);

		var newProduto = produtoService.atualizar(oldProduto, categoriaService);

		URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(newProduto.getNome()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoView(newProduto));

	}
	
	@RequestMapping(value = "/produtos/{id}", method = RequestMethod.DELETE)
	@CacheEvict(value = "listaDeProdutos", allEntries = true)
	public ResponseEntity<StatusOperacao> removeProdutPorId(@PathVariable Long id) {
		produtoService.removePorId(id);
		return ResponseEntity.ok(new StatusOperacao("Produto Removido com Sucesso!"));
	}
	
}



