package br.com.babypet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

//O Controller é responsavel em fazer a rota

import org.springframework.web.bind.annotation.RestController;

import br.com.babypet.domain.Cliente;
import br.com.babypet.services.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("clientes")
	public ResponseEntity<Cliente> Inserir() {
		
		Cliente cliente = clienteService.Incluir("Matheus Novo","2345678","matheus@gmail.com");
		
		return ResponseEntity.ok(cliente);
		
	}
}
