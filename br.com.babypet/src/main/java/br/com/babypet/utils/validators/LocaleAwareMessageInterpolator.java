package br.com.babypet.utils.validators;

import java.util.Locale;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;

//Esta classe comunica-se com um arquivo de mensagens
//e diz qual arquivo usar dependendo do idioma selecionado
public class LocaleAwareMessageInterpolator extends ResourceBundleMessageInterpolator {
	
	private Locale defaultLocale = Locale.getDefault();
	
	public void setDefaultLocale(Locale defaultLocale) {
		this.defaultLocale = defaultLocale;
		
	}
	
	//TODO

}
