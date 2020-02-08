package br.com.babypet.dtos.commands;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.babypet.utils.validators.CommandValidator;
import br.com.babypet.validators.CpfMustBeUnique;
import br.com.babypet.validators.CpfMustBeValid;

public class ClienteInsertCommand {
	
	@NotBlank(message="Nome deve ser informado")
	//Existem @Max, @Min(value = 50), por exemplo
	//para efetuar a validação e mais de uma pode
	//ser anotada para um mesmo campo. Esse é pra
	//números, size é pra String.
	@Size(min = 3, max = 50, message = "Nome deve estar entre 3 e 50")
	private String nome;
	
	@NotBlank(message="Cpf deve ser informado")
	@CpfMustBeValid
	@CpfMustBeUnique
	private String cpf;
	
	@NotBlank(message="E-mail deve ser informado")
	private String email;
	
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getEmail() {
		return email;
	}
	
	public void validate() {
		CommandValidator<ClienteInsertCommand> commandValidator =
				new CommandValidator<>();
		commandValidator.validate(this);//This valida uma instancia dessa mesma classe
	}
}
