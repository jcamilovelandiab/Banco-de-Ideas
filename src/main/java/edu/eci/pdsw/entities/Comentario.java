package edu.eci.pdsw.entities;

import java.sql.Date;

public class Comentario {
	private long id;
	private Date fecha;
	private String contenido;
	private Iniciativa	iniciativa;
	private Usuario usuario;
	
	public Comentario(String contenido, Iniciativa iniciativa, Usuario usuario) {
		this.contenido = contenido;
		this.iniciativa = iniciativa;
		this.usuario = usuario;
		this.fecha= new java.sql.Date((new java.util.Date()).getTime());
	}

	public Comentario(long id, String contenido, Iniciativa iniciativa, Usuario usuario) {
		this.id=id;
		this.contenido = contenido;
		this.iniciativa = iniciativa;
		this.usuario = usuario;
		this.fecha= new java.sql.Date((new java.util.Date()).getTime());
	}
	
	public Comentario() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Iniciativa getIniciativa() {
		return iniciativa;
	}

	public void setIniciativa(Iniciativa iniciativa) {
		this.iniciativa = iniciativa;
	}
	
}
