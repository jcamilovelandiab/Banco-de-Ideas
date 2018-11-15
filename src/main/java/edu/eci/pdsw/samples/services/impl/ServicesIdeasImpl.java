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
			
			if(consultarIniciativa(iniciativa.getNombre())!=null){
				throw new ServicesException("La iniciativa con el nombre "+iniciativa.getNombre() +" ya existe");
			}
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
			return iniciativaDAO.consultarIniciativa(nombreIniciativa);
		}catch(PersistenceException  ex) {
			System.err.println(ex.getMessage());
			throw new ServicesException("Error al consultar la iniciativa <"+nombreIniciativa+">");
		}
	}
	
	@Override
	public Collection<Iniciativa> consultarIniciativasxOrden(String orden) throws ServicesException {
		try{
			return iniciativaDAO.consultarIniciativasxOrden(orden);
		}catch(PersistenceException ex){
			System.err.println(ex.getMessage());
			throw  new SecurityException("Error al consultar una iniciativa por "+orden);
		}
	}

	@Override
	public Collection<Iniciativa> consultarIniciativas() throws ServicesException {
		try{
			return iniciativaDAO.consultarIniciativas();
		}catch(PersistenceException ex){
			System.err.println(ex.getMessage());
			throw  new SecurityException("Error al consultar todas las iniciativas");
		}
	}

	@Override
	public Collection<Iniciativa> consultarIniciativasxEstado(Estado estado) throws ServicesException {
		try{
			return iniciativaDAO.consultarIniciativasxEstado(estado);
		}catch(PersistenceException ex){
			System.err.println(ex.getMessage());
			throw  new SecurityException("Error al consultar todas las iniciativas");
		}
	}
	
	@Override
	public List<Iniciativa> consultarIniciativasRelacionadas(String nombreIni) throws ServicesException {
		try{
			return iniciativaDAO.consultarIniciativasRelacionadas(nombreIni);
		}catch(PersistenceException  ex) {
			throw new ServicesException("Error al consultar iniciativas relacionadas de "+nombreIni);
		}
	}
	
	@Override
	public Collection<Iniciativa> consultarIniciativasxClaves(List<String> palabrasClave) throws ServicesException {
		try{
			if(palabrasClave == null || palabrasClave.isEmpty() ) {
				return iniciativaDAO.consultarIniciativas();
			}
			TreeMap<String,Iniciativa> iniciativas = new TreeMap<String,Iniciativa>();
			for (String pclave : palabrasClave) {
				List<Iniciativa> inics = iniciativaDAO.consultarIniciativasxClaves(pclave);
				for (Iniciativa ini : inics) {
					if(!iniciativas.containsKey(ini.getNombre())) {
						iniciativas.put(ini.getNombre(), ini);
					}
				}
			}
			return iniciativas.values();
		}catch(PersistenceException  e) {
			e.printStackTrace();
			throw new ServicesException("Error al consultar iniciativas por palabras clave");
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
			return usuarioDAO.consultarVotantesxIniciativa(nombreIni).size();
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al consultar la cantidad de votos de la iniciativa "+nombreIni);
		}
	}
	
	@Override
	public List<Usuario> consultarInteresados(String nombreIni) throws ServicesException {
		try{
			return iniciativaDAO.consultarInteresados(nombreIni);
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al consultar los interesados en la iniciativa "+nombreIni);
		}
	}
	
	@Override
	public void modificarEstado(String nombreIniciativa, Estado estado) throws ServicesException {
		try{
			iniciativaDAO.modificarEstado(nombreIniciativa, estado);
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al modificar el estado de la iniciativa "+nombreIniciativa);
		}
	}
	
	
	
	@Override
	public void crearUsuario(Usuario usuario) throws ServicesException {
		try{
			usuarioDAO.crearUsuario(usuario);
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al crear un usuario");
		}
	}
	
	@Override
	public Usuario consultarUsuario(String correo) throws ServicesException {
		try{
			
			return usuarioDAO.consultarUsuario(correo);
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
	public void agregarVotanteAIniciativa(String correo, String nombreIni) throws ServicesException {
		try{
			if(consultarIniciativa(nombreIni)==null) {
				throw new ServicesException("La iniciativa <"+ nombreIni +"> no existe");
			}
			if(consultarUsuario(correo)==null) {
				throw new ServicesException("El usuario <"+ correo +"> no existe");
			}
			iniciativaDAO.agregarVotanteAIniciativa(correo, nombreIni);
		}catch(PersistenceException  ex) {
			System.err.println(ex.getMessage());
			throw new ServicesException("Error al registrar el voto de "+correo+" en la iniciativa "+ nombreIni);
		}
	}
	
	@Override
	public void eliminarVotanteAIniciativa(String correo, String nombreIni) throws ServicesException {
		try{
			if(consultarIniciativa(nombreIni)==null) {
				throw new ServicesException("La iniciativa <"+ nombreIni +"> no existe");
			}
			if(consultarUsuario(correo)==null) {
				throw new ServicesException("El usuario <"+ correo +"> no existe");
			}
			iniciativaDAO.eliminarVotanteAIniciativa(correo, nombreIni);
		}catch(PersistenceException  ex) {
			System.err.println(ex.getMessage());
			throw new ServicesException("Error al cancelar el voto del usuario "+ correo+ " de la iniciativa"+nombreIni);
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

	@Override
	public List<Iniciativa> consultarIniciativasxProponente(String correo) throws ServicesException {
		try{
			return iniciativaDAO.consultarIniciativasxProponente(correo);
		}catch(PersistenceException ex){
			System.err.println(ex.getMessage());
			throw  new SecurityException("Hay problema al buscar las iniciativas de "+correo);
		}
	}

	@Override
	public List<Usuario> consultarVotantesxIniciativa(String nombreIni) throws ServicesException {
		try{
			return usuarioDAO.consultarVotantesxIniciativa(nombreIni);
		}catch(PersistenceException ex){
			System.err.println(ex.getMessage());
			throw  new SecurityException("Hay problema los votantes de la iniciativa "+nombreIni);
		}
	}
	
}
