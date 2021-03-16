package com.cev.academia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cev.academia.domain.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {
	//Para buscar todas las notas de un alumno en concreto a traves del nif
	List<Nota> findByAlumno_nif(String nif);
	//Para buscar todas las notas de un alumno por nombre y apellidos
	List<Nota> findByAlumno_nombreAndAlumno_apellidos(String nombre, String apellidos);
}
