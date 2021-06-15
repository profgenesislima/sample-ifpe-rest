package br.edu.ifpe.gus.ads4arq.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpe.gus.ads4arq.entity.Categoria;

@RestController
public class CategoriaController {

	@RequestMapping("/categorias")
	@ResponseBody
	public List<Categoria> listar(){
		Categoria categoria = new Categoria("Brinquedo");
		Categoria categoria2 = new Categoria("Eletrônicos");
		Categoria categoria3 = new Categoria("Brinquedo");
		Categoria categoria4 = new Categoria("Brinquedo");
		return Arrays.asList(categoria, categoria2,categoria3,categoria4);
	}
}
