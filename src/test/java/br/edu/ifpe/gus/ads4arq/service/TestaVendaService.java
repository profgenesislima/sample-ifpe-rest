package br.edu.ifpe.gus.ads4arq.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.gus.ads4arq.entity.Categoria;
import br.edu.ifpe.gus.ads4arq.entity.FormaPagamento;
import br.edu.ifpe.gus.ads4arq.entity.Item;
import br.edu.ifpe.gus.ads4arq.entity.Produto;
import br.edu.ifpe.gus.ads4arq.entity.Venda;

public class TestaVendaService {

	
	private Produto produto;
	private Venda venda;
	private Item item;
	private VendaService vendaService;
	
	@BeforeEach
	public void inicializa() {
		
		produto = new Produto("Lego", 100.00, new Categoria("Brinquedo"));
		item = new Item(produto, 4);		
		venda = new Venda();
	}
	
	@Test
	public void testaPagamentoVendaComBoleto() {
		 venda.adicionarItem(item);
		 vendaService = new VendaService(venda, FormaPagamento.BOLETO);
		 assertEquals(360.0, vendaService.calculaValorFormaPagamento());
		 System.out.println(vendaService.getVenda().pegaValorTotal());
	}
	
	@Test
	public void testaPagamentoVendaComDebito() {
		 venda.adicionarItem(item);
		 vendaService = new VendaService(venda, FormaPagamento.DEBITO);
		 assertEquals(380.0, vendaService.calculaValorFormaPagamento());
		 System.out.println(venda.pegaValorTotal());
	}
}
