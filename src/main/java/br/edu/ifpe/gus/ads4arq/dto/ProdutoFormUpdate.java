package br.edu.ifpe.gus.ads4arq.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProdutoFormUpdate extends ProdutoForm{

	private Long id;
	
	public Long getId() {
		return id;
	}

	public ProdutoFormUpdate(String nome, String descricao, double preco, String categoriaNome, Long id) {
		super(nome, descricao, preco, categoriaNome);
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoFormUpdate other = (ProdutoFormUpdate) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProdutoFormUpdate [id=" + id + "]";
	}
	
	
	
}
