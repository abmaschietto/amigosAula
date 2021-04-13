package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.repository.AmigosRepository;

@Entity
@Table(name = "tb_amigos")
public class Amigos {
	
	@Id
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "idade")
	private Integer idade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Amigos [nome=" + nome + ", idade=" + idade + "]";
	}
	
}
