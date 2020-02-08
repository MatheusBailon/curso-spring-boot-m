package br.com.babypet.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;


//Esta classe � como uma gaveta que gerencia
//o contexto que queremos para determinado objeto que
//puxaremos em cpf must be unique pois l� o @Autowired n�o 
//funciona com o ClienteRepository

//Como ela vai mexer com o contexto da applica��o diretamente
//em runtime, ela deve ser anotada para que o spring a escaneie

@Component
public class ApplicationContextProvider implements ApplicationContextAware{
	
	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		ApplicationContextProvider.context = context;
	}
	
	public static SpringConstraintValidatorFactory getValidFactory () {
		AutowireCapableBeanFactory autowireCapable = ApplicationContextProvider.context.getAutowireCapableBeanFactory();
		
		return new SpringConstraintValidatorFactory(autowireCapable);
	}
	
	/*N�o ser� mais necess�rio
	public static<T> T getComponent(Class<T> type) {
		return ApplicationContextProvider.context.getBean(type);
	}
	*/
	
}
