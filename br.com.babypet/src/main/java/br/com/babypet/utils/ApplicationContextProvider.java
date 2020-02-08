package br.com.babypet.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


//Esta classe é como uma gaveta que gerencia
//o contexto que queremos para determinado objeto que
//puxaremos em cpf must be unique pois lá o @Autowired não 
//funciona com o ClienteRepository

//Como ela vai mexer com o contexto da applicação diretamente
//em runtime, ela deve ser anotada para que o spring a escaneie

@Component
public class ApplicationContextProvider implements ApplicationContextAware{
	
	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		ApplicationContextProvider.context = context;
	}
	
	public static<T> T getComponent(Class<T> type) {
		return ApplicationContextProvider.context.getBean(type);
	}
	
}
