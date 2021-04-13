package com.example.demo.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Amigos;
import com.example.demo.models.Inimigos;
import com.example.demo.services.AmigosService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(value = "*")
public class AmigosController {
	
	private static final Logger logger = LoggerFactory.getLogger(AmigosController.class);
	
	@Autowired
	private AmigosService amigosService;
	
	@GetMapping(value = "/amigo/{nome}")
	public ResponseEntity<Amigos> getMeuAmigoPorNome
	(@PathVariable(name = "nome", required = true)String nome){
		Amigos amigo = new Amigos();
		try {
			amigo = amigosService.findAmigosByName(nome);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return ResponseEntity.ok(amigo);
	}
	
	@PostMapping(value = "/registro")
	public ResponseEntity<String> registerMeuAmigo(@RequestBody Amigos amigo){
		String statusDatabase = amigosService.registerAmigo(amigo);
		return ResponseEntity.status(HttpStatus.CREATED).body(statusDatabase);
	}
	
	@DeleteMapping(value = "/rafao/traidor")
	public ResponseEntity<String> deleteMeuAmigo(@RequestParam String nome){
		String statusDatabase = amigosService.deleteAmigo(nome);
		return ResponseEntity.status(HttpStatus.GONE).body(statusDatabase);
	}
	
	@GetMapping(value = "/amigos")
	public ResponseEntity<List<Amigos>> allFriends(){
		List<Amigos> allFriends = amigosService.getAll();
		return ResponseEntity.ok(allFriends);
	}
	
	@GetMapping(value = "/inimigos")
	public ResponseEntity<List<Inimigos>> allEnemies(){
		List<Inimigos> allEnemies = amigosService.getEnemies();
		return ResponseEntity.ok(allEnemies);
	}

}
