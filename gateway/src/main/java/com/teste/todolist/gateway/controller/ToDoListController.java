package com.teste.todolist.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.teste.todolist.gateway.domain.lista.DadosAtualizacaoLista;
import com.teste.todolist.gateway.domain.lista.ListaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/list")
public class ToDoListController {
	@Autowired
	private ListaRepository repository;
@PostMapping
@Transactional
public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico  dados, UriComponentsBuilder uriBuilder) {
	var medico = new Medico(dados);
	repository.save(medico);
	var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
	return ResponseEntity.created(uri).body(new DadosdetalhadoMedico(medico));

}
@GetMapping
public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10,sort = {"nome"})Pageable paginacao){
	 var page =repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
		return ResponseEntity.ok(page);

	
}
@PutMapping
@Transactional
public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoLista  dados) {
	var medico  = repository.getReferenceById(dados.id());
	medico.atualizarInformacoes(dados);
		return ResponseEntity.ok(new DadosdetalhadoMedico(medico));

	
	}
@DeleteMapping("/{id}")
@Transactional
public ResponseEntity excluir (@PathVariable Long id) {
	var medico  = repository.getReferenceById(id);
	medico.excluir();
	return ResponseEntity.noContent().build();

}
@GetMapping("/{id}")
@Transactional
public ResponseEntity detalhar (@PathVariable Long id) {
	var medico  = repository.getReferenceById(id);
	return ResponseEntity.ok(new DadosdetalhadoMedico(medico));

}
}
