package com.teste.todolist.gateway.domain.lista;

public record DadosListagemLista(Long id,String titulo, String tarefa, Status status) {
	public DadosListagemLista(Lista lista) {
		this(lista.getId(),lista.getTitulo(), lista.getTarefa(),lista.getStatus());
	}
}
