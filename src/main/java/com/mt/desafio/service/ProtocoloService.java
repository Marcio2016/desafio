package com.mt.desafio.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mt.desafio.model.Protocolo;
import com.mt.desafio.repostory.ProtocoloRepository;


@Service
public class ProtocoloService {

	@Autowired
	private ProtocoloRepository repository;
	
	public Optional<Protocolo> findById(Long id) {
		Optional<Protocolo> protocolo = repository.findById(id);		
		
		return protocolo;
	}

	public List<Protocolo> index() {
		return repository.findAll();
	}

	public Protocolo store(Protocolo protocolo) {
		
		/*Gerando codigo Aleatório*/
		UUID uuid = UUID.randomUUID();		
		String codigo = uuid.toString().substring(0,6);
		
		/*Extrair Ano Atual*/
		Date ano = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(ano);
		Integer year = cal.get(Calendar.YEAR);	
		
		protocolo.setOficio(codigo+"/"+year.toString());
		protocolo.setCreate_at(new Date());
		
		return repository.save(protocolo);
	}

	public void delete(Long id) {
		repository.deleteById(id);
		
	}

	public Protocolo update(Long id, Protocolo protocolo) {
		Protocolo protocoloCadastrado = findByIdProtocol(id);		
		
		BeanUtils.copyProperties(protocolo, protocoloCadastrado, "id");
		return repository.save(protocoloCadastrado);
	}
	
	public Protocolo findByIdProtocol(Long id) {
		Protocolo protocoloCadastrado = this.repository.findById(id)
		.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return protocoloCadastrado;
	}
	
	
}
