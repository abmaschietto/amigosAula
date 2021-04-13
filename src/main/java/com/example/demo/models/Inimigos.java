package com.example.demo.models;

public class Inimigos {
	
	private String nome;
	
	private Integer tamanhoPeniano;
	
	public Inimigos() {}
	
	public Inimigos(String nome, Integer tamanhoPeniano) {
		super();
		this.nome = nome;
		this.tamanhoPeniano = tamanhoPeniano;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTamanhoPeniano() {
		return tamanhoPeniano;
	}

	public void setTamanhoPeniano(Integer tamanhoPeniano) {
		this.tamanhoPeniano = tamanhoPeniano;
	}

	@Override
	public String toString() {
		return "Inimigos [nome=" + nome + ", tamanhoPeniano=" + tamanhoPeniano + "]";
	}
	
	
	public static Inimigos transformAmigoToInimigo(Amigos amigo) {
		return new Inimigos(amigo.getNome(), -20);
	}

}
