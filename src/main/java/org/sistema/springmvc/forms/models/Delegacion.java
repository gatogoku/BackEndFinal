package org.sistema.springmvc.forms.models;

import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonAutoDetect

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Delegacion {

	@Override
	public String toString() {
		return "Delegacion [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", direccion="
				+ direccion + "]";
	}

	private int id;
	@Size(min = 5, max = 15, message = "Login must be between 5 and 15 characters long")
	private String nombre;
	@Size(min = 10, max = 100, message = "Login must be between 10 and 100 characters long")
	private String descripcion;
	@Size(min = 20, max = 40, message = "Login must be between 4 and 15 characters long")
	private String direccion;
	
	private Ciudad ciudad;
	private int idCiudad;

	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = ciudad.getId();
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Delegacion() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String description) {
		this.descripcion = description;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Delegacion(int id, String nombre, String description, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = description;
		this.direccion = direccion;

	}

}
