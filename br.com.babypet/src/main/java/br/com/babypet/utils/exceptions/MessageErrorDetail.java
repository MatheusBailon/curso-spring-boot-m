package br.com.babypet.utils.exceptions;

//Vamos detalhar qual campo deu erro
//Esta classe representa uma mensagem de erro na lista de mensagens que criaremos
public class MessageErrorDetail {
	
	private String field;
	private String errorMessage;
	
	public String getField() {
		return field;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public MessageErrorDetail(String field, String errorMessage) {
		this.field = field;
		this.errorMessage = errorMessage;
	}
	
	public MessageErrorDetail(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
