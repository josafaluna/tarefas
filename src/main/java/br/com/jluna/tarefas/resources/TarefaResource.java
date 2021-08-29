package br.com.jluna.tarefas.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.jluna.tarefas.entities.Tarefa;
import br.com.jluna.tarefas.services.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaResource {

	@Autowired
	private TarefaService service;

	@GetMapping
	public ResponseEntity<List<Tarefa>> buscaTarefas() {
		List<Tarefa> lista = service.findAll();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	public ResponseEntity<Tarefa> insert(@RequestBody Tarefa tarefa) {
		tarefa = service.insert(tarefa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tarefa.getId()).toUri();
		return ResponseEntity.created(uri).body(tarefa);
	}

}
