package br.com.babypet.utils.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;

import br.com.babypet.utils.exceptions.BadRequestException;
import br.com.babypet.utils.exceptions.MessageErrorDetail;

//Pode fazer a valida��o de todo e qualquer comando
//Existem algumas conven��es, tipo T = type
//Essa classe � uma generic
public class CommandValidator<T> extends AbstractValidator{
	
	//Vai ser chamado no comando (command) para validar
	//as informa��es que este est� passando.
	//Ele valida qualquer classe de command que passarmos
	public void validate(T command) {
		List<MessageErrorDetail> errors = new ArrayList<>();
		
		//Falta um monte de coisa pra fazer aqui
		//Aqui a lista de erros vai sendo preenchida
		//conforme os erros v�o sendo encontrados pelo
		//c�digo escrito exatamente aqui:
		
		LocaleAwareMessageInterpolator interpolator =
				new LocaleAwareMessageInterpolator();
		
		interpolator.setDefaultLocale(new Locale("pt", "BR"));
		
		//Como obter a mensagem no meu arquivo
		//O que precisamos � obter os validadores, mas para chegar nele,
		//precisamos passar pela configura��o dele atrav�s dos m�todos anteriores
		//� por causa dessa inst�ncia que precisamos extender 
		//ResourceBundleMessageInterpolator em LocaleMessageAwareInterpolator
		Validator validator = Validation
				.byDefaultProvider()
				.configure()
				.messageInterpolator(interpolator)
				.buildValidatorFactory()
				.getValidator();
		
		//Lista de erros(Viola��o de command)
		Set<ConstraintViolation<T>> violations = 
				validator.validate(command);
		
		//Vai adicionando erros na lista
		for(ConstraintViolation<T> violation : violations) {//For each
			setRuleViolation(violation);
			errors.add(new MessageErrorDetail(getField(),getMessage()));
		}
		
		if(!errors.isEmpty())
			throw new BadRequestException(errors);
	}

}
