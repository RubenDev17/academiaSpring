package com.cev.academia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cev.academia.domain.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
	//Con esta linea podremos hacer consultas de los alumnos que se llamen por el nombre que le indique.
	List<Alumno> findByNombre(String nombre);
	List<Alumno> findByNombreAndApellidos(String nombre, String apellidos);
	List<Alumno> findAllByOrderByNombre();
	//Hacemos una consulta para consultar los datos de todos los alumnos que tengan una nota superior a 8
	List<Alumno> findByNotas_calificacionGreaterThanEqual(int nota);
}
