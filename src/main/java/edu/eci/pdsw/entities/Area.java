package edu.eci.pdsw.entities;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Area {	

	private long id;
	private String nombre;
	private String descripcion;
	
	public Area() {
		
	}

	public Area(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		
	}
	
	public Area(long id, String nombre, String descripcion) {
		this.id= id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Area [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
}
