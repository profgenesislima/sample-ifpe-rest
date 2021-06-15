package br.edu.ifpe.gus.ads4arq.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//TDD - Test-Driven Development
public class TestaVenda {

	private Produto produto;
	private Venda venda;
	private Item item;

	@BeforeEach
	public void inicializa() {

		produto = new Produto("Lego", 100.00, new Categoria("Brinquedo"));
		item = new Item(produto, 4);
		venda = new Venda();
	}

	@Test
	public void testaPegaValorTotalDaVenda() {
		venda.adicionarItem(item);
		assertEquals(360.00, venda.pegaValorTotal());
	}

	@Test
	public void testaRegistroDeProdutoNaVenda() {
		venda.adicionarItem(item);
		assertEquals("Lego", venda.getItens().get(0).getProduto().getNome());
	}

	@Test
	public void testaEncapsulamentoDaClasseVendaAoInserirProduto() {

		assertThrows(UnsupportedOperationException.class, () -> venda.getItens().add(item));
	}

	@Test
	public void testaInsereMesmoProdutoNaVenda() {
		venda.adicionarItem(item);
		venda.adicionarItem(item);

		assertEquals(1, venda.getItens().size());

	}

	@Test
	public void testaDescontoDaVendaAPartirDeTresProdutos() {
		venda.adicionarItem(item);
		assertEquals(360.00, venda.pegaValorTotal());

	}

}
