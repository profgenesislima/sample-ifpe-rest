package br.edu.ifpe.gus.ads4arq.service;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.gus.ads4arq.entity.Item;

public class DescontoService {

	private VendaService vendaService;

	public DescontoService(VendaService vendaService) {
		this.vendaService = vendaService;
	}
	
	public double calculaDescontoProdutoSimilares(double total) {
		List<Item> itensComTresUnidadesSimilares = new ArrayList<>();
		vendaService.getVenda().getItens().stream().filter(i->i.getQuantidade() >= 3).forEach(itensComTresUnidadesSimilares::add);
		var valorTotalItensSimilares = 0.00;
		
		if(itensComTresUnidadesSimilares.size() > 0) {
		for (Item item : itensComTresUnidadesSimilares) {
			valorTotalItensSimilares = total * 0.1;
		}
		total -= valorTotalItensSimilares;
		}
		return total;
	}
}
