package edu.eci.pdsw.entities;

import java.util.ArrayList;

public class Usuario {
	private String correo;
	private String nombre;
	private Area area;
	private Rol tipo;
	private ArrayList<Iniciativa> iniciativas; 
	private ArrayList<Iniciativa> votos;
	private ArrayList<Comentario> comentario;
	private ArrayList<Interes> interes;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String correo,Area area, Rol tipo) {
        this.nombre = nombre;
        this.correo=correo;
        this.area= area;
        this.tipo=tipo;
        this.iniciativas = new ArrayList<Iniciativa>();
        this.votos=new ArrayList<Iniciativa>();
        this.comentario= new ArrayList<Comentario>();
        this.interes= new ArrayList<Interes>();
    }
           
    public ArrayList<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(ArrayList<Comentario> comentario) {
		this.comentario = comentario;
	}

	public ArrayList<Interes> getInteres() {
		return interes;
	}

	public void setInteres(ArrayList<Interes> interes) {
		this.interes = interes;
	}

	public ArrayList<Iniciativa> getVotos() {
		return votos;
	}

	public void setVotos(ArrayList<Iniciativa> votos) {
		this.votos = votos;
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
    	this.area= area;
    }
    public Rol getTipo() {
        return tipo;
    }

    public void setTipo(Rol tipo) {
    	this.tipo= tipo;
    }

	public ArrayList<Iniciativa> getIniciativas() {
		return iniciativas;
	}

	public void setIniciativas(ArrayList<Iniciativa> iniciativas) {
		this.iniciativas = iniciativas;
	}
 
    
}
