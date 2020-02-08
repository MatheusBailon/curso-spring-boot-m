package br.com.babypet.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.babypet.domain.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String>{

	/* Aqui o proprio motor do SpringData constroi o m�todo para realizar a pesquisa
	 * precisamos usar apenas algumas palavras chaves no nome do m�todo 
	 * Ex: findBy...
	 * 
	 * */
	
	boolean existsByCpf(String cpf);
	
	
	List<Cliente> findByNome(String nome);
	
}
