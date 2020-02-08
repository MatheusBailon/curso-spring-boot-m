package br.com.babypet.validators;

import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CpfMustBeUniqueValidator.class)
public @interface CpfMustBeUnique {
	
	public String message () default "CPF JÁ CADASTRADO";
	
	public Class<?>[] groups() default {};
	public Class<? extends Payload>[] payload() default {};
}
