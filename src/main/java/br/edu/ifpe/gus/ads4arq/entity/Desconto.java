package br.edu.ifpe.gus.ads4arq.entity;

public class Desconto {

	private Venda venda;

	public Desconto(Venda venda) {
		this.venda = venda;
	}

	public Venda getVenda() {
		return venda;
	}
	
	
}
