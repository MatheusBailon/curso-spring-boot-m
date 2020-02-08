package br.com.babypet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.babypet.domain.Cliente;
import br.com.babypet.dtos.commands.ClienteInsertCommand;
import br.com.babypet.dtos.commands.ClienteUpdateCommand;
import br.com.babypet.repositories.ClienteRepository;
import br.com.babypet.utils.exceptions.NotFoundException;

@Service
public class ClienteService {
  
  @Autowired
  private ClienteRepository clienteRepository;
  
  public Cliente incluir(ClienteInsertCommand command) {
    
    Cliente cliente = Cliente.criar(command);
    
    return clienteRepository.save( cliente );
  }
  
  public List<Cliente> listar(){
	  return clienteRepository.findAll();
  }
  
  public List<Cliente> filtrar(String nome){
	  return clienteRepository.findByNome(nome);
  }
  
  public Cliente consultar(String id) {
	  return clienteRepository.findById(id)
			  .orElseThrow(() -> new NotFoundException());
  }
  
  public Cliente alterar(String id, ClienteUpdateCommand command) {
	  Cliente cliente = consultar(id);
	  cliente.editar(command);
	  return clienteRepository.save(cliente);
  }
  
  public void excluir(String id) {
	  Cliente cliente = consultar(id);
	  clienteRepository.delete(cliente);
  }
  
}
