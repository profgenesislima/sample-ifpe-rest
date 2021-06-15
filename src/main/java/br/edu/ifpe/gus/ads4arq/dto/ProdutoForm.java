package br.edu.ifpe.gus.ads4arq.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class ProdutoForm {
	
	
	
	@NotEmpty
	private String nome;
	private String descricao;
	@NotNull
	@DecimalMin(value = "0.00")
	@Digits(integer = 6, fraction = 2)
	private double preco;
	@NotEmpty
	private String categoriaNome;
	
	public ProdutoForm(String nome, String descricao, double preco, String categoriaNome) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoriaNome = categoriaNome;
	}
	
	public ProdutoForm() {
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getCategoriaNome() {
		return categoriaNome;
	}
	public void setCategoriaNome(String categoriaNome) {
		this.categoriaNome = categoriaNome;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoriaNome == null) ? 0 : categoriaNome.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
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
		ProdutoForm other = (ProdutoForm) obj;
		if (categoriaNome == null) {
			if (other.categoriaNome != null)
				return false;
		} else if (!categoriaNome.equals(other.categoriaNome))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ProdutoForm [nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", categoriaNome="
				+ categoriaNome + "]";
	}
	
	
	
	

}
