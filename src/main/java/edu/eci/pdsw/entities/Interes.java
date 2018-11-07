package edu.eci.pdsw.entities;

import java.sql.Date;

public class Interes {
	private long id;
	private String intencion;
	private String descripcion;
	private Date fecha;
	private Boolean trabajo;
	
	public Interes() {
		
	}
	
	public Interes(String intencion,String descripcion, Boolean trabajo) {
		this.intencion = intencion;
		this.fecha = new java.sql.Date((new java.util.Date()).getTime());
		this.trabajo = trabajo;
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setId(long id) {
		this.id = id;
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
	
	
}
