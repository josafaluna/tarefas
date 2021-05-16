package br.com.jluna.tarefas.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tarefa")
public class Tarefa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String subTitulo;
	private String autor;

	@Column(columnDefinition = "TEXT")
	private String detalhe;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private LocalDate dtCriacao;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private LocalDateTime dtInicio;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private LocalDateTime dtFim;
	private StatusTarefa status;
	private Responsavel responsavel;

	private Set<Tarefa> tags = new HashSet<Tarefa>();

}
