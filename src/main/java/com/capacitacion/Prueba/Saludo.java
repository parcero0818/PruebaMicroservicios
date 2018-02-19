package com.capacitacion.Prueba;

public class Saludo {
	private long id;
	private String mensaje;

	public Saludo() {
		// TODO Auto-generated constructor stub
	}
	
	public Saludo(long id, String mensaje) {
		this.id= id;
		this.mensaje= mensaje;
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
