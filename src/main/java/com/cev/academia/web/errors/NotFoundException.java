package com.cev.academia.web.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Utilizamos el decordador ResponseStatus para que cuando se produzca un fallo le llege el 404 al cliente y no se rompa todo.
@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	//Definimos el constructor para que le llegue un mensaje por pantalla.
	
	public NotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
}
