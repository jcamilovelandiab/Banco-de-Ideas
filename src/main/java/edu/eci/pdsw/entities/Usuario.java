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
	
	public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo=correo;
        this.tipo = Rol.PUBLICO;
        Area areaT = new Area("Decanatura de Sistemas","decanatura del programa de decanatura de sistemas"); areaT.setId(1);
        this.area = areaT;
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

    
    public boolean equals(Usuario usr) {
        return this.nombre.equals(usr.getNombre()); //To change body of generated methods, choose Tools | Templates.
    }
    
        
    
}
