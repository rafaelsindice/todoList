package com.teste.todolist.gateway.domain.lista;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoLista(
		@NotNull
		Long id, 
		String titulo,
		String tarefa,
		Status status	) {

}
