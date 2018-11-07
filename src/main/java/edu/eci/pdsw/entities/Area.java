package edu.eci.pdsw.entities;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Area {
	private long id;
	private String nombre;
	private String descripcion;
	private ArrayList<Usuario> usuarios;
	
	public Area() {
		
	}

	public Area(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuarios= new ArrayList<Usuario>();
	}
	
	public Area(long id, String nombre, String descripcion) {
		this.id= id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuarios= new ArrayList<Usuario>();
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
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
	
	
}
