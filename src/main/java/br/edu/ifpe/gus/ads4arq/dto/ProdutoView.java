package br.edu.ifpe.gus.ads4arq.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.edu.ifpe.gus.ads4arq.entity.Produto;

public class ProdutoView {

	private String produtoNome;
	private String produtoDescricao;
	private double produtoPreco;
	private String categoriaNome;

	public ProdutoView(Produto produto) {
		this.produtoNome = produto.getNome();
		this.produtoPreco = produto.getPreco();
		this.produtoDescricao = produto.getDescricao();
		this.categoriaNome = produto.getCategoria().getNome();
	}

	public String getProdutoNome() {
		return produtoNome;
	}

	public String getProdutoDescricao() {
		return produtoDescricao;
	}

	public double getProdutoPreco() {
		return produtoPreco;
	}

	public String getCategoriaNome() {
		return categoriaNome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoriaNome == null) ? 0 : categoriaNome.hashCode());
		result = prime * result + ((produtoDescricao == null) ? 0 : produtoDescricao.hashCode());
		result = prime * result + ((produtoNome == null) ? 0 : produtoNome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(produtoPreco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoView other = (ProdutoView) obj;
		if (categoriaNome == null) {
			if (other.categoriaNome != null)
				return false;
		} else if (!categoriaNome.equals(other.categoriaNome))
			return false;
		if (produtoDescricao == null) {
			if (other.produtoDescricao != null)
				return false;
		} else if (!produtoDescricao.equals(other.produtoDescricao))
			return false;
		if (produtoNome == null) {
			if (other.produtoNome != null)
				return false;
		} else if (!produtoNome.equals(other.produtoNome))
			return false;
		if (Double.doubleToLongBits(produtoPreco) != Double.doubleToLongBits(other.produtoPreco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProdutoCategoriaDTO [produtoNome=" + produtoNome + ", produtoDescricao=" + produtoDescricao
				+ ", produtoPreco=" + produtoPreco + ", categoriaNome=" + categoriaNome + "]";
	}

	public static List<ProdutoView> convert(List<Produto> produtos) {

		return produtos.stream().map(ProdutoView::new).collect(Collectors.toList());
//		return produtos.map(ProdutoView::new);
	}

	public static Page<ProdutoView> convert(Page<Produto> produtos) {

		return produtos.map(ProdutoView::new);
	}
	
	public static ProdutoView convert(Produto produto) {
		ProdutoView produtoView = new ProdutoView(produto);
		return produtoView;
	}

}
