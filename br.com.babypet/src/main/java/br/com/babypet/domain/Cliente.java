package br.com.babypet.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.babypet.dtos.commands.ClienteInsertCommand;
import br.com.babypet.dtos.commands.ClienteUpdateCommand;
import br.com.babypet.utils.exceptions.BadRequestException;

//Um rich domain

@Document (collection = "cliente")
public class Cliente {
  
  @Id
  private String id;
  private String nome;
  private String cpf;
  private String email;
  
  public String getId( ) { return id; }
  public String getNome( ) { return nome; }
  public String getCpf( ) { return cpf; }
  public String getEmail( ) { return email; }
  
  protected Cliente() {
	  
  }
  
  private Cliente(ClienteInsertCommand command) {
	  
	  //command.validate();
	  
    this.nome = command.getNome();
    this.cpf = command.getCpf();
    this.email = command.getEmail();
  }
  
  public void editar(ClienteUpdateCommand command) {//talvez seja no clienteUpdate
	  this.nome = command.getNome();
	  this.email= command.getEmail();
  }
  
  //Retirado a resposabilidade do contrutor de realizar a validação aqui no que chamamos de "FABRICAÇÃO"
  //A diferença entre o construtor e um "Fabricador" é que o construtor constroi já alocando espaço na memória
  public static Cliente criar(ClienteInsertCommand command) {
	  command.validate();
	  return new Cliente(command);
  }
}
