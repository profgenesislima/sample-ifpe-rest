package br.edu.ifpe.gus.ads4arq.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Single Responsibility Principle
public class Venda {

	private List<Item> itens = new ArrayList<>();

	public void adicionarItem(Item item) {
		if (!itens.contains(item))
			itens.add(item);
	}

	public double pegaValorTotal() {
		var total = 0.00;

		for (Item item : itens) {
			total += item.getProduto().getPreco() * item.getQuantidade();
		}
		return total;
	}

	public List<Item> getItens() {
		return Collections.unmodifiableList(itens);
	}




}
