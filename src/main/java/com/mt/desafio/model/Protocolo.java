package com.mt.desafio.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Protocolo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;	

	private String oficio;
	
	@NotBlank
	@NotNull(message = "O preencimento da origem é obrigatório!")
	private String origem;
	
	@NotBlank
	@NotNull(message = "O preencimento da descricao é obrigatório!")
	@Size(min = 6, max = 50)
	private String descricao;
	
	@NotBlank
	@NotNull(message = "O preencimento do solicitante é obrigatório!")
	private String solicitante;
	
	private Date create_at;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public Date getCreate_at() {
		return create_at;
	}

	
	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Protocolo other = (Protocolo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
