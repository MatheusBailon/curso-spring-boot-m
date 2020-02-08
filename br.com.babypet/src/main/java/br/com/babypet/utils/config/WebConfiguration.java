package br.com.babypet.utils.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Esta classe serve para alterar o padr�o de pagina��o, que � implementada a partir desta interface
// Esta inteface � especifico para padroes de pagina��o, caso altere outra coisa ser� necess�rio implementar outra classe
// por isso a utiliza��o deste pacote de config

@Configuration
public class WebConfiguration implements WebMvcConfigurer{

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		// TODO Auto-generated method stub
		PageableHandlerMethodArgumentResolver pageableResolver= new PageableHandlerMethodArgumentResolver();
		
		pageableResolver.setFallbackPageable(PageRequest.of(0, 10));
		
		resolvers.add(pageableResolver);
	}
}
