package br.com.babypet.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.babypet.repositories.ClienteRepository;
import br.com.babypet.utils.ApplicationContextProvider;

public class CpfMustBeUniqueValidator implements ConstraintValidator<CpfMustBeUnique, String>{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	//Um m�todo chamado quando uma classe � inicializada
	//Basicamente um @Autowired na marra
	/* Este cara n�o ser� mais utilizado
	@Override
	public void initialize(CpfMustBeUnique constraintAnnotation) {
		this.clienteRepository = ApplicationContextProvider.getComponent(ClienteRepository.class);
	}
	*/
	
	@Override
	public boolean isValid(String cpf, ConstraintValidatorContext context) {
		//A regra � simples: Se existe o cpf -> false
		
		return !clienteRepository.existsByCpf(cpf);
	}
	
	

}
