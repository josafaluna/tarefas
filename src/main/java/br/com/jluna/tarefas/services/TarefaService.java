package br.com.jluna.tarefas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jluna.tarefas.entities.Tarefa;
import br.com.jluna.tarefas.reposotories.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository repository;

	@Transactional(readOnly = true)
	public List<Tarefa> findAll() {
		return repository.findAll();
	}

	public Tarefa insert(Tarefa tarefa) {
		tarefa = repository.save(tarefa);
		return tarefa;
	}

}
