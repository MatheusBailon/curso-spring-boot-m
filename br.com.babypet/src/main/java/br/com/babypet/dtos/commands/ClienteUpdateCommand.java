package br.com.babypet.dtos.commands;

import javax.validation.constraints.NotBlank;

public class ClienteUpdateCommand {
	
	@NotBlank(message="Nome deve ser informado")
	private String nome;
	@NotBlank(message="Email deve ser informado")
	private String email;
	
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	

}