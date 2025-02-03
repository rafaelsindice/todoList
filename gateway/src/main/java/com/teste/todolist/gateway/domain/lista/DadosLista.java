package com.teste.todolist.gateway.domain.lista;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosLista(
		@NotBlank
		String nome, 
		@NotBlank
		
		@NotBlank
		String  telefone,
		
		@NotNull
		Status status){
}
