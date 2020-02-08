package br.com.babypet.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.babypet.repositories.ClienteRepository;
import br.com.babypet.utils.ApplicationContextProvider;

public class CpfMustBeUniqueValidator implements ConstraintValidator<CpfMustBeUnique, String>{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	//Um método chamado quando uma classe é inicializada
	//Basicamente um @Autowired na marra
	/* Este cara não será mais utilizado
	@Override
	public void initialize(CpfMustBeUnique constraintAnnotation) {
		this.clienteRepository = ApplicationContextProvider.getComponent(ClienteRepository.class);
	}
	*/
	
	@Override
	public boolean isValid(String cpf, ConstraintValidatorContext context) {
		//A regra é simples: Se existe o cpf -> false
		
		return !clienteRepository.existsByCpf(cpf);
	}
	
	

}
