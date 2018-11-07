package edu.eci.pdsw.entities;

import java.sql.Date;

public class Comentario {
	private long id;
	private Date fecha;
	private String contenido;
	private Usuario autor;
	
	public Comentario(String contenido, Usuario autor) {
		this.contenido = contenido;
		this.autor = autor;
		this.fecha= new java.sql.Date((new java.util.Date()).getTime());
	}
	
	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
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
	
}
