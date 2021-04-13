package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Amigos;
import com.example.demo.models.Inimigos;
import com.example.demo.repository.AmigosRepository;

@Service
public class AmigosService {
	
	private static final Logger logger = LoggerFactory.getLogger(AmigosService.class);
	
	@Autowired
	private AmigosRepository amigosRepo;
	
	public Amigos findAmigosByName(String name) {
		logger.info("Buscando o amigao");
		Optional<Amigos> podeSerQueTenhaOLuca = amigosRepo.findByNomeIgnoringCase(name);
		if(!podeSerQueTenhaOLuca.isPresent()) {
			throw new RuntimeException("Nenhum amigão encontrado");
		}
		Amigos amigos = podeSerQueTenhaOLuca.get();
		return amigos;
	}
	
	public String registerAmigo(Amigos amigo) {
		try {
			amigosRepo.save(amigo);
			return "Salvo com sucesso";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return e.getMessage();
		}
	}
	
	public String deleteAmigo(String nome) {
		try {
			amigosRepo.deleteById(nome);
			return "O amigo: " + nome + " foi deletado!";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return e.getMessage();
		}
	}
	
	public List<Amigos> getAll(){
		List<Amigos> listaAmigos = amigosRepo.findAll();
		return listaAmigos;
	}
	
	public List<Inimigos> getEnemies(){
		List<Inimigos> listaInimigos = amigosRepo.findAll().stream().map(Inimigos::transformAmigoToInimigo).collect(Collectors.toList());
		return listaInimigos;
	}

}
