package com.capacitacion.Prueba.repository;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pais implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private int pa_id;
	private String pa_nombre;
	
	public int getPa_id() {
		return pa_id;
	}
	public void setPa_id(int pa_id) {
		this.pa_id = pa_id;
	}
	public String getPa_nombre() {
		return pa_nombre;
	}
	public void setPa_nombre(String pa_nombre) {
		this.pa_nombre = pa_nombre;
	}
	
}
