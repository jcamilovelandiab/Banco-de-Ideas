package edu.eci.pdsw.samples.services.impl;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import edu.eci.pdsw.entities.Area;
import edu.eci.pdsw.entities.Comentario;
import edu.eci.pdsw.entities.Estado;
import edu.eci.pdsw.entities.Iniciativa;
import edu.eci.pdsw.entities.Interes;
import edu.eci.pdsw.entities.Rol;
import edu.eci.pdsw.entities.Usuario;
import edu.eci.pdsw.samples.services.ServicesException;
import edu.eci.pdsw.samples.services.ServicesIdeas;

public class ServicesIdeasStub implements ServicesIdeas{
	
	private final Map<Long, Area> areas;
	private final Map<Long, Iniciativa> iniciativas;
	private final Map<Long, Comentario> comentarios;
	private final Map<Long, Interes> intereses;
	private final Map<String,Usuario> usuarios;
	
	public ServicesIdeasStub() {
		areas = new HashMap<>();
		iniciativas = new HashMap<>();
		comentarios = new HashMap<>();
		intereses = new HashMap<>();
		usuarios = new HashMap<>();
	}
	
	@Override
	public void crearIniciativa(Iniciativa iniciativa) throws ServicesException {
		if (!iniciativas.containsKey(iniciativa.getNo_iniciativa())) {
			iniciativas.put(iniciativa.getNo_iniciativa(), iniciativa);
		}else{
		    throw new ServicesException("La iniciativa no "+iniciativa.getNo_iniciativa()+" ya esta registrado.");
		}
	}

	@Override
	public Iniciativa consultarIniciativa(long idIniciativa) throws ServicesException {
		Iniciativa ini = null;
		if(iniciativas.containsKey(idIniciativa)) {
			ini = iniciativas.get(idIniciativa);
		}
		return ini;
	}
	
	/**
	 * Retorna todas las iniciativas sin un orden
	 */
	@Override
	public List<Iniciativa> consultarIniciativas(String orden) throws ServicesException {
		return  new LinkedList<>(iniciativas.values());
	}

	@Override
	public List<Iniciativa> consultarIniciativasRelacionadas(Iniciativa iniciativa) throws ServicesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Iniciativa> consultarIniciativasxClaves(List<String> palabrasClave) throws ServicesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Iniciativa> consultarIniciativasxEstado(Estado estado) throws ServicesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarComentario(Usuario usuario, Iniciativa iniciativa, Comentario comentario)
			throws ServicesException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int consultarCantidadVotos(long idIniciativa) throws ServicesException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Usuario> consultarInteresados(long idIniciativa) throws ServicesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarEstado(long idIniciativa, Estado estado) throws ServicesException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearUsuario(Usuario usuario) throws ServicesException {
		if (!usuarios.containsKey(usuario.getCorreo())) {
			usuarios.put(usuario.getCorreo(), usuario);
		}else{
		    throw new ServicesException("El usuario con correo "+usuario.getCorreo()+" ya esta registrado.");
		}
	}

	@Override
	public Usuario consultarUsuario(String correo) throws ServicesException {
		Usuario usr = null;
		if(usuarios.containsKey(correo)) {
			usr = usuarios.get(correo);
		}
		return usr;
	}

	@Override
	public List<Usuario> consultarUsuarios() throws ServicesException {
		return  new LinkedList<>(usuarios.values());
	}

	@Override
	public boolean autenticarUsuario(Usuario usuario) throws ServicesException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void votarxIniciativa(String correoUsuario, long idIniciativa) throws ServicesException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelarVotoIniciativa(String correoUsuario, long idIniciativa) throws ServicesException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarInteresxIniciativa(String correoUsuario, long idIniciativa, Interes interes)
			throws ServicesException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void asignarPerfil(String correoUsuario, Rol tipo) throws ServicesException {
		if(usuarios.containsKey(correoUsuario)) {
			usuarios.get(correoUsuario).setTipo(tipo);
		}else{
			throw new ServicesException("El usuario con correo "+correoUsuario+" no existe.");
		}
	}

	@Override
	public File consultarEstadisticas() throws ServicesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarPalabraClave(long ini, String desc) throws ServicesException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int existeUsuario(String correo) throws SecurityException {
		// TODO Auto-generated method stub
		return 0;
	}

}
