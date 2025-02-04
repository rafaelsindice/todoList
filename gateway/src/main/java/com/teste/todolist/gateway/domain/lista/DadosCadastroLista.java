package com.teste.todolist.gateway.domain.lista;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroLista(
		@NotBlank
		String titulo, 
		@NotBlank
		
		@NotBlank
		String  tarefa,
		
		@NotNull
		Status status){
}
