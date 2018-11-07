package edu.eci.pdsw.entities;

import java.util.ArrayList;

public class Usuario {
	

	private String correo;
	private String nombre;
	private Area area;
	private Rol tipo;
	private ArrayList<Interes> intereses;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String correo,Area area, Rol tipo) {
        this.nombre = nombre;
        this.correo=correo;
        this.area= area;
        this.tipo=tipo;
    }

	public ArrayList<Interes> getInteres() {
		return intereses;
	}

	public void setInteres(ArrayList<Interes> interes) {
		this.intereses = interes;
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
 
	@Override
	public String toString() {
		return "Usuario [correo=" + correo + ", nombre=" + nombre + ", area=" + area + ", tipo=" + tipo
				+ ", iniciativas=" + "]";
	}
    
}
