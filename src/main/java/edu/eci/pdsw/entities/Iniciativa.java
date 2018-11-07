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
	private ArrayList<String> palabrasClave;
	private ArrayList<Usuario> votos;
	private ArrayList<Comentario> comentario;
	private ArrayList<Interes> interes;
	private Usuario usuario;
	
	public Iniciativa() {
		
	}
	
	public Iniciativa(String nombre, String descripcion,Estado estado, Usuario usuario) {
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.fechaCierre=null;
		this.usuario=usuario;
		this.palabrasClave= new ArrayList<String>();
		this.votos= new ArrayList<Usuario>();
		this.comentario= new ArrayList<Comentario>();
		this.interes= new ArrayList<Interes>();
		this.estado=estado;
	}
	public ArrayList<Interes> getInteres() {
		return interes;
	}
	public void setInteres(ArrayList<Interes> interes) {
		this.interes = interes;
	}
	public ArrayList<Comentario> getComentario() {
		return comentario;
	}
	public void setComentario(ArrayList<Comentario> comentario) {
		this.comentario = comentario;
	}
	public ArrayList<Usuario> getVotos() {
		return votos;
	}
	public void setVotos(ArrayList<Usuario> votos) {
		this.votos = votos;
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
