package edu.eci.pdsw.entities;

import java.sql.Date;

public class Interes {
	private long id;
	private String intencion;
	private Date fecha;
	private Boolean trabajo;
	private Usuario usuario;
	private Iniciativa iniciativa;
	
	public Interes() {
		
	}
	
	public Interes(long id, String intencion, Boolean trabajo, Usuario usuario, Iniciativa iniciativa) {
		this.id = id;
		this.intencion = intencion;
		this.fecha = new java.sql.Date((new java.util.Date()).getTime());
		this.trabajo = trabajo;
		this.usuario = usuario;
		this.iniciativa = iniciativa;
	}
	
	public Interes(String intencion, Boolean trabajo, Usuario usuario, Iniciativa iniciativa) {
		this.intencion = intencion;
		this.fecha = new java.sql.Date((new java.util.Date()).getTime());
		this.trabajo = trabajo;
		this.usuario = usuario;
		this.iniciativa = iniciativa;
	}

	
	public long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getIntencion() {
		return intencion;
	}
	
	public void setIntencion(String intencion) {
		this.intencion = intencion;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Boolean getTrabajo() {
		return trabajo;
	}
	
	public void setTrabajo(Boolean trabajo) {
		this.trabajo = trabajo;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Iniciativa getIniciativa() {
		return iniciativa;
	}
	
	public void setIniciativa(Iniciativa iniciativa) {
		this.iniciativa = iniciativa;
	}
	
	
}
