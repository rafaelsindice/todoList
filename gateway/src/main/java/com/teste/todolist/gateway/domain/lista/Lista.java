package com.teste.todolist.gateway.domain.lista;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "listas")
@Entity(name = "Lista")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Lista {
	
	public Lista(DadosCadastroLista dados) {
		this.titulo=dados.titulo();
		this.tarefa=dados.tarefa();
		this.status=dados.status();
		this.ativo=true;
		
		
	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String tarefa;
	@Enumerated(EnumType.STRING)
	private Status status;
	private Boolean ativo; 
	
	public void atualizarInformacoes(@Valid DadosAtualizacaoLista dados) {
		if (dados.titulo()!=null) {
			this.titulo=dados.titulo();		
		}
		if(dados.tarefa()!=null) {
			this.tarefa=dados.tarefa();
		}
		if (dados.status()!=null) {
			this.status=dados.status();
		}
		if (dados.ativo()) {
			this.ativo=dados.ativo();
		}
	}
	public void excluir() {
		this.ativo=false;		
	}
	
}

