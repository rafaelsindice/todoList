package com.teste.todolist.gateway.domain.lista;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ListaRepository extends JpaRepository<Lista, Long>{
	Page<Lista> findAll(Pageable paginacao);
}
