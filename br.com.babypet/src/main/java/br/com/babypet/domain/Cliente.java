package br.com.babypet.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cliente")
public class Cliente {

	//Utilizo uma String no id, porque no Mongo o identificador é do tipo GUID
	private String id;
	private String nome;
	private String cpf;
	private String email;
	
	public String getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	//Utilizamos um construtor ao invés dos setters porque facilita na validação das entradas
	public Cliente(String nome, String cpf, String email) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}
	
//	Precisamos de uma FABRICA
}
