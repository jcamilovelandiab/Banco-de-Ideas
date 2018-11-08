package edu.eci.pdsw.samples.services.impl;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.entities.*;
import edu.eci.pdsw.persistence.*;
import edu.eci.pdsw.samples.services.*;


public class ServicesIdeasImpl  implements ServicesIdeas{
	
	@Inject
	private UsuarioDAO usuarioDAO;
	@Inject
	private IniciativaDAO iniciativaDAO;
	
	@Override
	public void crearIniciativa(Iniciativa iniciativa) throws ServicesException {
		try{
			iniciativa.setNombre(iniciativa.getNombre().toLowerCase());
			iniciativa.setDescripcion(iniciativa.getDescripcion().toLowerCase());
			iniciativaDAO.crearIniciativa(iniciativa);
			for(String pclave: iniciativa.getPalabrasClave()) {
				iniciativaDAO.agregarPalabraClave(iniciativa.getNombre(), pclave.toLowerCase());
			}
		}catch(PersistenceException  ex) {
			System.err.println(ex.getMessage());
			throw new ServicesException("Error al crear la iniciativa <"+iniciativa.getNombre()+">");
		}
	}
	
	@Override
	public Iniciativa consultarIniciativa(String nombreIniciativa) throws ServicesException {
		try {
			return iniciativaDAO.consultarIniciativa(nombreIniciativa.toLowerCase());
		}catch(PersistenceException  ex) {
			System.err.println(ex.getMessage());
			throw new ServicesException("Error al consultar la iniciativa <"+nombreIniciativa+">");
		}
	}
	
	@Override
	public List<Iniciativa> consultarIniciativas(String orden) throws ServicesException {
		try{
			return iniciativaDAO.consultarIniciativas(orden.toLowerCase());
		}catch(PersistenceException  ex) {
			System.err.println(ex.getMessage());
			throw new ServicesException("Error al consultar todas las iniciativas");
		}
	}
	
	@Override
	public List<Iniciativa> consultarIniciativasRelacionadas(Iniciativa iniciativa) throws ServicesException {
		try{
			return iniciativaDAO.consultarIniciativasRelacionadas(iniciativa);
		}catch(PersistenceException  ex) {
			throw new ServicesException("Error al consultar iniciativas relacionadas de "+iniciativa.getNombre());
		}
	}
	
	@Override
	public Collection<Iniciativa> consultarIniciativasxClaves(List<String> palabrasClave) throws ServicesException {
		
		try{
			TreeMap<String,Iniciativa> iniciativas = new TreeMap<String,Iniciativa>();
			for (String pclave : palabrasClave) {
				//System.out.println("PALABRA CLAVE - <"+pclave+">");
				List<Iniciativa> inics = iniciativaDAO.consultarIniciativasxClaves(pclave.toLowerCase());
				for (Iniciativa ini : inics) {
					if(!iniciativas.containsKey(ini.getNombre())) {
						iniciativas.put(ini.getNombre(), ini);
					}
				}
			}
			return iniciativas.values();
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al consultar iniciativas por palabras clave");
		}
	}
	
	@Override
	public List<Iniciativa> consultarIniciativasxEstado(Estado estado) throws ServicesException {
		try{
			return iniciativaDAO.consultarIniciativasxEstado(estado);
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al crear una iniciativa por estado "+estado.name());
		}
	}
	
	@Override
	public void agregarComentario(Usuario usuario, Iniciativa iniciativa, Comentario comentario) throws ServicesException {
		try{
			iniciativaDAO.agregarComentario(usuario, iniciativa, comentario);
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al agregar el comentario a la iniciativa "+iniciativa.getNombre());
		}
	}
	
	@Override
	public int consultarCantidadVotos(String nombreIni) throws ServicesException {
		try{
			return iniciativaDAO.consultarCantidadVotos(nombreIni.toLowerCase());
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al consultar la cantidad de votos de la iniciativa "+nombreIni);
		}
	}
	
	@Override
	public List<Usuario> consultarInteresados(String nombreIni) throws ServicesException {
		try{
			return iniciativaDAO.consultarInteresados(nombreIni.toLowerCase());
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al consultar los interesados en la iniciativa "+nombreIni);
		}
	}
	
	@Override
	public void modificarEstado(String nombreIniciativa, Estado estado) throws ServicesException {
		try{
			iniciativaDAO.modificarEstado(nombreIniciativa.toLowerCase(), estado);
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al modificar el estado de la iniciativa "+nombreIniciativa);
		}
	}
	
	
	
	@Override
	public void crearUsuario(Usuario usuario) throws ServicesException {
		try{
			usuario.setCorreo(usuario.getCorreo().toLowerCase());
			usuarioDAO.crearUsuario(usuario);
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al crear un usuario");
		}
	}
	
	@Override
	public Usuario consultarUsuario(String correo) throws ServicesException {
		try{
			
			return usuarioDAO.consultarUsuario(correo.toLowerCase());
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al consultar el usuario con correo "+correo);
		}
	}
	
	@Override
	public List<Usuario> consultarUsuarios() throws ServicesException {
		try{
			return usuarioDAO.consultarUsuarios();
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al consultar todos los usuarios");
		}
	}
	
	@Override
	public boolean autenticarUsuario(Usuario usuario) throws ServicesException {
		try{
			return usuarioDAO.autenticarUsuario(usuario);
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al autenticar el usuario "+usuario.getNombre());
		}
	}
	
	@Override
	public void votarxIniciativa(String correoUsuario, String nombreIniciativa) throws ServicesException {
		try{
			usuarioDAO.votarxIniciativa(correoUsuario.toLowerCase(),nombreIniciativa);
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al votar por la iniciativa "+ nombreIniciativa);
		}
	}
	
	@Override
	public void cancelarVotoIniciativa(String correoUsuario, String nombreIniciativa) throws ServicesException {
		try{
			usuarioDAO.cancelarVotoIniciativa(correoUsuario.toLowerCase(), nombreIniciativa);
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al cancelar el voto del usuario "+ correoUsuario+ " de la iniciativa"+nombreIniciativa);
		}
	}
	
	@Override
	public void mostrarInteresxIniciativa(String correoUsuario,String nombreIniciativa, Interes interes) throws ServicesException {
		try{
			usuarioDAO.mostrarInteresxIniciativa(correoUsuario, nombreIniciativa, interes);	
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al mostrar interes del usuario "+correoUsuario+" por la iniciativa "+ nombreIniciativa);
		}
	}
	
	@Override
	public File consultarEstadisticas() throws ServicesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void asignarPerfil(String correoUsuario, Rol tipo) throws ServicesException {
		try{
			usuarioDAO.asignarPerfil(correoUsuario, tipo);	
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al asignarle un perfil a "+correoUsuario);
		}
		
	}
	
	@Override
	public int existeUsuario(String correo)throws SecurityException{
		try{
			return usuarioDAO.existeUsuario(correo);
		}catch(PersistenceException ex){
			throw  new SecurityException("Hay problema al encontrar el usuario");
		}
	}
}
