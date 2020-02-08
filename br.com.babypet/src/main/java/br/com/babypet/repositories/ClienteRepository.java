package br.com.babypet.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.babypet.domain.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String>{

	/* Aqui o proprio motor do SpringData constroi o método para realizar a pesquisa
	 * precisamos usar apenas algumas palavras chaves no nome do método 
	 * Ex: findBy...
	 * 
	 * */
	
	boolean existsByCpf(String cpf);
	
	
	List<Cliente> findByNomeIgnoreCase(String nome);
	
	
	// -> Aqui dentro (value = "") passo a consulta
	// O $regex, tenta encontrar algum texto que conténha na string de destino,
	// Ou seja, caso a string tenha só uma parte do que procuro já será o suficiente
	// para acha-lo Ex: nome: "Rafael Nada", vai ser encontrado com o $regex: 'Rafael'
	@Query(value = "{"   
			       + "$or: "
			       + "[ "
			       +" { 'nome': { $regex: '?0', '$options': 'i' } },"
			       +"{ 'email': { $regex: '?1', '$options': 'i' } } "
			       +"] }"
		)
	List<Cliente> findByArgumentos(String nome, String email);
}
