package br.com.babypet.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.babypet.domain.Cliente;
import br.com.babypet.dtos.commands.ClienteInsertCommand;
import br.com.babypet.dtos.commands.ClienteUpdateCommand;
import br.com.babypet.dtos.models.ClienteItemModel;
import br.com.babypet.dtos.models.ClienteListModel;
import br.com.babypet.services.ClienteService;

@RestController
@RequestMapping("clientes") //É um path padrão todos os métodos terão esse nome no início, antes do seu proprio mapeamento
public class ClienteController {
	
  @Autowired
  private ClienteService clienteService;
  
  @PostMapping
  public ResponseEntity<?> inserir(
		  @RequestBody ClienteInsertCommand command) {
    
    Cliente cliente = 
            clienteService.incluir(command);
    
    return ResponseEntity.ok( cliente );
  }
  
  @GetMapping
  public ResponseEntity<?> listar(){
	  List<Cliente> clientes = clienteService.listar();
	  List<ClienteListModel> model = ClienteListModel.ofList(clientes);
	  return ResponseEntity.ok(model);
  }
  
  //Utiliza Query String
  @GetMapping("filtro")
  public ResponseEntity<?> filtrar(@RequestParam String nome){
	  List<Cliente> clientes = clienteService.filtrar(nome);
	  List<ClienteListModel> model = ClienteListModel.ofList(clientes);
	  return ResponseEntity.ok(model);
  }
  
  @GetMapping("{id}")
  public ResponseEntity<?> consultar(
		  @PathVariable(name = "id") String id){
	  Cliente cliente = clienteService.consultar(id);
	  ClienteItemModel model = ClienteItemModel.of(cliente);
	  return ResponseEntity.ok(model);
  }
  
  @PutMapping("{id}")
  public ResponseEntity<?> alterar(
	  @PathVariable(name="id") String id,
		  @Valid @RequestBody ClienteUpdateCommand command){
	  Cliente cliente = clienteService.alterar(id, command);
	  return ResponseEntity.ok(cliente);
  }
  
  @DeleteMapping("{id}")
  public ResponseEntity<?> excluir (@PathVariable(name="id") String id){
	  clienteService.excluir(id);
	  return ResponseEntity.ok().build();
  }
  
  
}
