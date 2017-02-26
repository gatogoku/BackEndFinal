package org.sistema.springmvc.forms.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.Range;

@JsonAutoDetect
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

//@Entity @Table(name="Ciudad") @Proxy(lazy = false) 
public class Ciudad {

	private int id;

	@Size(min = 5, max = 30, message = "Login must be between 4 and 15 characters long")
	@Pattern(regexp = "[A-Za-z]+", message = "Must contain only chars ")
	private String nombre;

	@Pattern(regexp = "[0-9]{5}", message = "Must contain only 5 numbers ")
	private String cpostal;

	@Range(min = 1, max = 100, message = "Solo numero de 1 hasta 100")
	private int idProvincia;

	@Override
	public String toString() {
		return "Ciudad [id=" + id + ", nombre=" + nombre + ", cpostal=" + cpostal + ", idProvincia=" + idProvincia
				+ ", delegaciones= ";
	}

	public Ciudad() {

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

	public String getCpostal() {
		return cpostal;
	}

	public void setCpostal(String cpostal) {
		this.cpostal = cpostal;
	}

	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public Ciudad(int id, String nombre, String cpostal, int idProvincia) {
		this.id = id;
		this.nombre = nombre;
		this.cpostal = cpostal;
		this.idProvincia = idProvincia;
	}

}
