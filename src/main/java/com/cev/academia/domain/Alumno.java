package com.cev.academia.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Con Entity indicamos que esto es una entidad, es decir, que habra en mi base de datos una tabla asociada a esta clase.
@Entity
public class Alumno {
	//Con esto le decimos que esto es el identificador. El id siempre será unico, no habra dos iguales
	@Id
	//Con este decorador, le diremos nuestro id es único y cada vez que insertemos un alumno nuevo se autoincremente este valor
	//de forma automatica y se vaya asignado este valor a la entidad.
	@GeneratedValue
	private long id;
	
	//Con esto le decimos que es una columna de la tabla y en nuestra base de datos queremos que se llame nombre
	@Column(name="nombre")
	private String nombre;
	
	//Hacemos lo mismo con los demás campos
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="nif")
	private String nif;
	
	
	//Creamos la relación en la que un alumno (oneTo) tiene muchas notas (many). Es una relacion 1 a n
	//El alumno esta referenciado desde nota con el mappedBy
	@OneToMany(mappedBy="alumno")
	//Con el siguiente decorador le decimos que campo queremos que ignore del  campo notas cuando mostramos nota desde alumnno.
	//Nos mostraria una vez el alumno y todas sus notas. Sino no terminaría nunca el bucle y nos mostraria por cada nota siempre los campos de alumno también.
	@JsonIgnoreProperties({"alumno"})
	//Creamos una lista de objetos nota para tener las notas de los alumnos
	List<Nota> notas;

	//IMPORTANTE OBLIGATORIO
	//Creamos los getter y setter para que haga el mapeo en los campos de la tabla
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
	
}
