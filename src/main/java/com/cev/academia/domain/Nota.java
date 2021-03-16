package com.cev.academia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Nota {

	@Id
	@GeneratedValue
	private long id;
	
	//Esto sera una columna de nuestra tabla
	//Recordamos que name es el nombre que tendrá en la tabla
	@Column(name="calificacion")
	private int calificacion;
	
	@Column(name="observaciones")
	private String observaciones;
	
	
	//Creamos la relación con alumno. Un alumno tiene varias notas (many) a un alumno (ToOne)
	@ManyToOne
	//Le decimos que cuando nos dé los datos de notas ignore alumnos por cada nota que nos dé.
	@JsonIgnoreProperties({"notas"})
	private Alumno alumno;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
}
