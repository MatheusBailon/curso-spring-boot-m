package br.com.babypet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.babypet.domain.Cliente;
import br.com.babypet.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired //o Autowired consegue criar a instancia a partir desta Integrace, para que possa ser utilizada "como se fosse uma classe"
	private ClienteRepository clienteRepository;
	
	public Cliente Incluir(String nome, String cpf, String email) {
		
		Cliente cliente = new Cliente(nome,cpf,email);
		
		return clienteRepository.save(cliente);
	}
	
	
}
