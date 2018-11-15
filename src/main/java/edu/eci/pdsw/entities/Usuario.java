package edu.eci.pdsw.entities;

import java.util.ArrayList;

public class Usuario {
	

	private String correo;
	private String nombre;
	private Area area;
	private Rol tipo;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String correo,Area area, Rol tipo) {
        this.nombre = nombre;
        this.correo=correo;
        this.area= area;
        this.tipo=tipo;
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
		return "Usuario [correo=" + correo + ", nombre=" + nombre + ", area=" + area + ", tipo=" + tipo + "]";
	}

    
}
