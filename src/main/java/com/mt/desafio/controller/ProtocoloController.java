package com.mt.desafio.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mt.desafio.model.Protocolo;
import com.mt.desafio.service.ProtocoloService;

@RestController
@RequestMapping(value = "/protocolo")
public class ProtocoloController {

	@Autowired
	private ProtocoloService service;
	
	
	@GetMapping
	public List<Protocolo> listar() {
		return service.index();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Protocolo> buscar(@PathVariable Long id) {
		Optional<Protocolo> protocolo = service.findById(id);
		
		return protocolo.isPresent() ?
				ResponseEntity.ok(protocolo.get()) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Protocolo adicionar(@Valid @RequestBody  Protocolo protocolo) {
		return service.store(protocolo);
	}
	
	
	@PutMapping("/{id}")	
	public ResponseEntity<Protocolo> atualizar(@PathVariable Long id, @Valid @RequestBody Protocolo protocolo) {
		Protocolo protocoloAtualizado = service.update(id, protocolo);
		
		return ResponseEntity.ok(protocoloAtualizado); 
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		service.delete(id);
	}
	

}
