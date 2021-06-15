package br.edu.ifpe.gus.ads4arq.service;

import br.edu.ifpe.gus.ads4arq.entity.FormaPagamento;
import br.edu.ifpe.gus.ads4arq.entity.Venda;
//OCP - Open-Closed Principle
public class VendaService{

	private Venda venda;
	private FormaPagamento formaPagamento;

	public VendaService(Venda venda,FormaPagamento formaPagamento) {
		this.venda = venda;
		this.formaPagamento = formaPagamento;
			}

	public Venda getVenda() {
		return venda;
	}
	
	
	public double calculaValorFormaPagamento() {
		var total = venda.pegaValorTotal();
		switch (formaPagamento) {
		case BOLETO:
			total -= total * 0.1;
			break;        
		case DEBITO:
			total -= total * 0.05;
			break;
		case IFPAY:
			total -= total * 0.01;
		default:
			break;
		}
		return total;
	}

	
	
	
}
