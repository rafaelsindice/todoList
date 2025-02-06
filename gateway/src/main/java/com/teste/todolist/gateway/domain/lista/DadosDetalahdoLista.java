package com.teste.todolist.gateway.domain.lista;

public record DadosDetalahdoLista(Long id,
		String titulo,
		String tarefa,
		Status status,
		boolean ativo) {

	public DadosDetalahdoLista(Lista lista) {
		
		this(lista.getId(), lista.getTitulo(), lista.getTarefa(),lista.getStatus(), lista.getAtivo());
		
	}
}
