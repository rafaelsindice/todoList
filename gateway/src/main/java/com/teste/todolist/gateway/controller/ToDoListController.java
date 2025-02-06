package com.teste.todolist.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.teste.todolist.gateway.domain.lista.DadosAtualizacaoLista;
import com.teste.todolist.gateway.domain.lista.DadosCadastroLista;
import com.teste.todolist.gateway.domain.lista.DadosDetalahdoLista;
import com.teste.todolist.gateway.domain.lista.DadosListagemLista;
import com.teste.todolist.gateway.domain.lista.Lista;
import com.teste.todolist.gateway.domain.lista.ListaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/lists")
public class ToDoListController {
	@Autowired
	private ListaRepository repository;
@PostMapping
@Transactional
public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroLista dados, UriComponentsBuilder uriBuilder) {
	var lista = new Lista(dados);
	repository.save(lista);
	var uri = uriBuilder.path("/lists/{id}").buildAndExpand(lista.getId()).toUri();
	return ResponseEntity.created(uri).body(new DadosListagemLista(lista));

}
@GetMapping
public ResponseEntity<Page<DadosListagemLista>> listar(@PageableDefault(size = 10,sort = {"titulo"})Pageable paginacao){
	 var page =repository.findAll(paginacao).map(DadosListagemLista::new);
		return ResponseEntity.ok(page);

	
}
@PutMapping
@Transactional
public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoLista  dados) {
	var lista  = repository.getReferenceById(dados.id());
	lista.atualizarInformacoes(dados);
		return ResponseEntity.ok(new DadosDetalahdoLista(lista));

	
	}
@DeleteMapping("/{id}")
@Transactional
public ResponseEntity excluir (@PathVariable Long id) {
	var lista  = repository.getReferenceById(id);
	lista.excluir();
	return ResponseEntity.noContent().build();

}
@GetMapping("/{id}")
@Transactional
public ResponseEntity detalhar (@PathVariable Long id) {
	var lista  = repository.getReferenceById(id);
	return ResponseEntity.ok(new DadosDetalahdoLista(lista));

}
}
