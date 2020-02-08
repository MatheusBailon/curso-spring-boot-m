package br.com.babypet.utils.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Esta classe serve para alterar o padrão de paginação, que é implementada a partir desta interface
// Esta inteface é especifico para padroes de paginação, caso altere outra coisa será necessário implementar outra classe
// por isso a utilização deste pacote de config

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
