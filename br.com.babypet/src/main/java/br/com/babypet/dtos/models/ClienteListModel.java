package br.com.babypet.dtos.models;

import java.util.List;
import java.util.stream.Collectors;

import br.com.babypet.domain.Cliente;

public class ClienteListModel {
	
	private String id;
	private String nome;
	private String cpf;
	
	public String getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	
	private static ClienteListModel of (Cliente cliente) {
		ClienteListModel model = new ClienteListModel();
		model.id = cliente.getId();
		model.nome = cliente.getNome();
		model.cpf = cliente.getCpf();
		
		return model;
	}
	
	public static List<ClienteListModel> ofList (List<Cliente> clientes){
		return clientes.stream().
				map(cliente -> of(cliente)).//O map transforma esse 1 cliente em um of(cliente)
				collect(Collectors.toList());
		
	}

}
