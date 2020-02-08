package br.com.babypet.dtos.models;

import br.com.babypet.domain.Cliente;

public class ClienteItemModel {

	public String idCLiente;
	public String nomeCliente;
	
	public String getIdCLiente() {
		return idCLiente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public static ClienteItemModel of (Cliente cliente) {
		ClienteItemModel model = new ClienteItemModel();
		
		model.idCLiente = cliente.getId();
		model.nomeCliente = cliente.getNome();
		
		return model;
	}
}