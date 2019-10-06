package br.com.workmade.model;

public class Autor {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Autor(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Autor [nome=" + nome + "]";
	}
	
	

}
