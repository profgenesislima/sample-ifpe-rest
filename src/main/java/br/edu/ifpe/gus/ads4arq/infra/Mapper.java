package br.edu.ifpe.gus.ads4arq.infra;

public interface Mapper<S,T>{

	T map (S source);
}
