package edu.eci.pdsw.entities;

import java.sql.Date;

public class Interes {
	private long id;
	private String intencion;
	private String descripcion;
	private Date fecha;
	private Boolean trabajo;
	private Usuario interesado;
	
	public Interes() {
		
	}
	
	public Interes(String intencion,String descripcion, Boolean trabajo, Usuario interesado) {
		this.intencion = intencion;
		this.fecha = new java.sql.Date((new java.util.Date()).getTime());
		this.trabajo = trabajo;
		this.descripcion = descripcion;
		this.interesado = interesado;
	}
	
	public Usuario getInteresado() {
		return interesado;
	}

	public void setInteresado(Usuario interesado) {
		this.interesado = interesado;
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
	
	@Override
	public String toString() {
		return "Interes [id=" + id + ", intencion=" + intencion + ", descripcion=" + descripcion + ", fecha=" + fecha
				+ ", trabajo=" + trabajo + ", interesado=" + interesado + "]";
	}
	
}
