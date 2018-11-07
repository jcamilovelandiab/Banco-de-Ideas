package edu.eci.pdsw.entities;

import java.sql.Date;
import java.util.ArrayList;

public class Iniciativa {
	private long no_iniciativa;
	private String nombre;
	private String descripcion;
	private Date fechaPropuesta;
	private Date fechaCierre;
	private Estado estado;
	private Usuario proponente;
	private ArrayList<String> palabrasClave;
	private ArrayList<Usuario> votantes;
	private ArrayList<Comentario> comentarios;
	private ArrayList<Interes> intereses;
	
	public Iniciativa() {
		
	}
	
	public Iniciativa(String nombre, String descripcion,Estado estado, Usuario usuario) {
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.fechaPropuesta = new java.sql.Date((new java.util.Date()).getTime());
		this.fechaCierre=null;
		this.proponente=usuario;
		this.palabrasClave= new ArrayList<String>();
		this.votantes= new ArrayList<Usuario>();
		this.comentarios= new ArrayList<Comentario>();
		this.intereses= new ArrayList<Interes>();
		this.estado=estado;
	}
	
	public ArrayList<Interes> getInteres() {
		return intereses;
	}
	
	public void setInteres(ArrayList<Interes> interes) {
		this.intereses = interes;
	}

	public ArrayList<Comentario> getComentario() {
		return comentarios;
	}
	
	@Override
	public String toString() {
		return "Iniciativa [no_iniciativa=" + no_iniciativa + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", fechaPropuesta=" + fechaPropuesta + ", fechaCierre=" + fechaCierre + ", estado=" + estado
				+ ", palabrasClave=" + palabrasClave + ", proponente=" + proponente + "]";
	}

	public void setComentario(ArrayList<Comentario> comentario) {
		this.comentarios = comentario;
	}
	
	public ArrayList<Usuario> getVotos() {
		return votantes;
	}
	
	public void setVotos(ArrayList<Usuario> votos) {
		this.votantes = votos;
	}
	
	public Long getNo_iniciativa() {
		return no_iniciativa;
	}
	
	public void setNo_iniciativa(long no_iniciativa) {
		this.no_iniciativa = no_iniciativa;
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
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Date getFechaPropuesta() {
		return fechaPropuesta;
	}
	
	public void setFechaPropuesta(Date fechaPropuesta) {
		this.fechaPropuesta = fechaPropuesta;
	}
	
	public Date getFechaCierre() {
		return fechaCierre;
	}
	
	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public ArrayList<String> getPalabrasClave() {
		return palabrasClave;
	}
	
	public void setPalabrasClave(ArrayList<String> palabrasClave) {
		this.palabrasClave = palabrasClave;
	}

	public Usuario getProponente() {
		return proponente;
	}

	public void setProponente(Usuario proponente) {
		this.proponente = proponente;
	}

	public ArrayList<Usuario> getVotantes() {
		return votantes;
	}

	public void setVotantes(ArrayList<Usuario> votantes) {
		this.votantes = votantes;
	}

	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(ArrayList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public ArrayList<Interes> getIntereses() {
		return intereses;
	}

	public void setIntereses(ArrayList<Interes> intereses) {
		this.intereses = intereses;
	}

}
