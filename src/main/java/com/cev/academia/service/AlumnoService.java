package com.cev.academia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cev.academia.domain.Alumno;
import com.cev.academia.repositories.AlumnoRepository;

//Con la anotación Service convertimos la clase java en un servicio
@Service
public class AlumnoService {
	
	//Inyectamos nuestro repositorio con la anotacion autowired
	@Autowired
	private AlumnoRepository alumnoRepository;
	//Este metodo recibe el alumno que me va a pasar el controller, lo va a guardar en la base de datos
	//y va a devolverlo con ese id ya asignado
	public Alumno postAlumno (Alumno alumno) {
		//Con la función save guardaremos todos los campos de alumno
		return alumnoRepository.save(alumno);
	}
	
	//Implementamos un método que nos devuelva todos los alumnos
	public List<Alumno> getAlumnos(){
		//obtenemos los datos del repositorio
		return alumnoRepository.findAllByOrderByNombre();
	}
	
	//Creamos un método para buscar ese id específico.
	//Con Optional evitaremos nulos. Si existe el alumno enviaremos el alumnos y sino enviaremos un alumno vacio.
	public Optional<Alumno> getAlumno(long id){
		//Obtenemos los datos del repositorio.
		return alumnoRepository.findById(id);
	}
}
