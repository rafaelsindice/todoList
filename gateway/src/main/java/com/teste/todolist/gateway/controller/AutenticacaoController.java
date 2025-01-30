package com.teste.todolist.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.todolist.gateway.security.DadosTokenJWT;
import com.teste.todolist.gateway.security.TokenService;
import com.teste.todolist.gateway.domain.usuario.DadosAutenticacao;
import com.teste.todolist.gateway.domain.usuario.Usuario;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
	  @Autowired
	    private AuthenticationManager manager;

	    @Autowired
	    private TokenService tokenService;

	    @PostMapping
	    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
	        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
	        var authentication = manager.authenticate(authenticationToken);

	        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());


	        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
	    }
}
