package br.com.babypet.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.babypet.domain.Cliente;
import br.com.babypet.dtos.commands.ClienteInsertCommand;
import br.com.babypet.dtos.commands.ClienteUpdateCommand;
import br.com.babypet.dtos.models.ClienteItemModel;
import br.com.babypet.dtos.models.ClienteListModel;
import br.com.babypet.services.ClienteService;
import br.com.babypet.utils.models.PageModel;

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
  
  //Pageable - para utilizar paginação
  @GetMapping
  public ResponseEntity<?> listar(Pageable pageable){
	  Page<Cliente> clientes = clienteService.listar(pageable);
	  //List<ClienteListModel> model = ClienteListModel.ofList(clientes);
	  PageModel<Cliente,ClienteListModel> model = ClienteListModel.ofPage(clientes);
	  return ResponseEntity.ok(model);
  }
  
  //Utiliza Query String
  @GetMapping("filtro")
  public ResponseEntity<?> filtrar(@RequestParam(required = false) String nome, @RequestParam(required = false) String email){
	  List<Cliente> clientes = clienteService.filtrar(nome,email);
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
