package com.cev.academia.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cev.academia.domain.Alumno;
import com.cev.academia.service.AlumnoService;
import com.cev.academia.web.errors.NotFoundException;

//Con la anotacion RestController le decimos a la clase java que sea un controlador.
@RestController
public class AlumnoController {
	
	//Queremos que este disponible nuestro servicio dentro del controlador
	@Autowired
	AlumnoService alumnoService;
	
	//Le indicamos que esto es un post y le indicamos con el path que es para alumnos
	@PostMapping(path="alumnos")
	//Con el RequestBody recuperamos el json con los datos y recibimos un alumno (dentro del objeto recojeremos la informacion
	//del json cuando se haga un post de alumnos)
	public Alumno postAlumno(@RequestBody Alumno alumno) {
		//Dentro del post llamo al postalumno de nuestro servicio
		return alumnoService.postAlumno(alumno);
	}
	
	//Vamos hacer un get, para ello utilizamos GetMapping
	@GetMapping(path="alumnos")
	public List<Alumno> getAlumnos(){
		//LLamamos al método del servicio. Desde el controlador lo único que haremos será escuchar la petición
		//y dar una respuesta desde el servicio
		return alumnoService.getAlumnos();
	}
	
	//Vamos hacer un get de un alumno en concreto segun su id
		@GetMapping(path="alumnos/{id}")
		//Recuperaremos el campo id con el decorador pathVariable.Con ello le decimos que nuestro dato va a ser variable
		//El numero de id que le pidamos lo recogeremos en la variable long que hemos puesto.
		//Con este id lo mandaremos al service para que nos localice un usuario con ese id asociado.
		public Alumno getAlumno(@PathVariable(name="id") long id){
			//Como getAlumno del service utiliza Optional no podremos devolver simplemente el método del servicio.
			//Utilizamos Optional como se resultado y usaremos el if por si alumno es vacio o si tiene datos.
			Optional<Alumno> result = alumnoService.getAlumno(id);
			if(result.isPresent()) {
				return result.get();
			}else {
				throw new NotFoundException("Alumno con id "+ id + " no encontrado");
			}
		}
}
