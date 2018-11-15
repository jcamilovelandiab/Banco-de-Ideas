package edu.eci.pdsw.samples.services.impl;

import java.io.File;
import java.util.Arrays;
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
	@Inject
	private ComentarioDAO comentarioDAO;
	@Inject
	private InteresDAO interesDAO;
	
	/**
	 * Crea una iniciativa
	 */
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
	
	/**
	 * Consulta una iniciativa dada su nombre
	 * @param nombreIniciativa
	 */
	@Override
	public Iniciativa consultarIniciativa(String nombreIniciativa) throws ServicesException {
		try {
			return iniciativaDAO.consultarIniciativa(nombreIniciativa);
		}catch(PersistenceException  ex) {
			System.err.println(ex.getMessage());
			throw new ServicesException("Error al consultar la iniciativa <"+nombreIniciativa+">");
		}
	}
	
	/**
	 * Consulta las iniciativas y las ordena segun un orden dado
	 * @param orden
	 */
	@Override
	public Collection<Iniciativa> consultarIniciativasxOrden(String orden) throws ServicesException {
		try{
			return iniciativaDAO.consultarIniciativasxOrden(orden);
		}catch(PersistenceException ex){
			System.err.println(ex.getMessage());
			throw  new SecurityException("Error al consultar una iniciativa por "+orden);
		}
	}
	
	/**
	 * Consulta todas las iniciativas
	 */
	@Override
	public Collection<Iniciativa> consultarIniciativas() throws ServicesException {
		try{
			return iniciativaDAO.consultarIniciativas();
		}catch(PersistenceException ex){
			System.err.println(ex.getMessage());
			throw  new SecurityException("Error al consultar todas las iniciativas");
		}
	}
	
	/**
	 * Consulta todas las iniciativas segun un estado
	 * @param estado
	 */
	@Override
	public Collection<Iniciativa> consultarIniciativasxEstado(Estado estado) throws ServicesException {
		try{
			return iniciativaDAO.consultarIniciativasxEstado(estado);
		}catch(PersistenceException ex){
			System.err.println(ex.getMessage());
			throw  new SecurityException("Error al consultar todas las iniciativas");
		}
	}
	
	/**
	 * Consulta las iniciativas relacionadas a una iniciativa
	 * @param nombreIni Nombre de la iniciativa
	 */
	@Override
	public List<Iniciativa> consultarIniciativasRelacionadas(String nombreIni) throws ServicesException {
		try{
			return iniciativaDAO.consultarIniciativasRelacionadas(nombreIni);
		}catch(PersistenceException  ex) {
			throw new ServicesException("Error al consultar iniciativas relacionadas de "+nombreIni);
		}
	}
	
	/**
	 * Consulta las iniciativas dada unas palabras clave
	 * @param palabrasClave
	 */
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
	
	/**
	 * Consulta la cantidad de votos de una iniciativa
	 * @param nombreIni Nombre de la iniciativa
	 */
	@Override
	public int consultarCantidadVotos(String nombreIni) throws ServicesException {
		try{
			return usuarioDAO.consultarVotantesxIniciativa(nombreIni).size();
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al consultar la cantidad de votos de la iniciativa "+nombreIni);
		}
	}
	
	/**
	 * Modifica el estado de una iniciativa
	 * @param nombreIniciativa
	 * @param estado Estado de la iniciativa
	 */
	@Override
	public void modificarEstado(String nombreIniciativa, Estado estado) throws ServicesException {
		try{
			iniciativaDAO.modificarEstado(nombreIniciativa, estado);
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al modificar el estado de la iniciativa "+nombreIniciativa);
		}
	}
	
	
	/**
	 * Crea un usuario
	 * @param usuario
	 */
	@Override
	public void crearUsuario(Usuario usuario) throws ServicesException {
		try{
			usuarioDAO.crearUsuario(usuario);
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al crear un usuario");
		}
	}
	
	/**
	 * Consulta un usuario dado un correo
	 * @param correo Correo del usuario
	 */
	@Override
	public Usuario consultarUsuario(String correo) throws ServicesException {
		try{
			
			return usuarioDAO.consultarUsuario(correo);
		}catch(PersistenceException  ex) {
			System.err.println(ex.getMessage());
            throw new ServicesException("Error al consultar el usuario con correo "+correo);
		}
	}
	
	/**
	 * Consulta todos los usuarios registrados
	 */
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
	
	/**
	 * Agrega un usuario que vota por una iniciativa
	 * @param correo Correo del usuario
	 * @param nombreIni Nombre de la iniciativa
	 */
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
	
	/**
	 * Elimina un usuario que voto por una iniciativa
	 * @param correo Correo del usuario
	 * @param nombreIni Nombre de la iniciativa	
	 */
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
	
	/**
	 * Un usuario muestra el interes por una iniciativa
	 * @param nombreIniciativa
	 * @param interes
	 */
	@Override
	public void usuarioMuestraInteresxIniciativa(String nombreIniciativa, Interes interes) throws ServicesException {
		try{
			interesDAO.usuarioMuestraInteresxIniciativa(nombreIniciativa, interes);
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al mostrar interes del usuario "+interes.getInteresado()+" por la iniciativa "+ nombreIniciativa);
		}
	}
	
	@Override
	public File consultarEstadisticas() throws ServicesException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * Asigna el rol a un usuario
	 * @param correoUsuario
	 * @param tipo Rol del usuario
	 */
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

	/**
	 * Consulta las iniciativas de un usuario proponente
	 * @param correo Correo del usuario
	 */
	@Override
	public List<Iniciativa> consultarIniciativasxProponente(String correo) throws ServicesException {
		try{
			return iniciativaDAO.consultarIniciativasxProponente(correo);
		}catch(PersistenceException ex){
			System.err.println(ex.getMessage());
			throw  new SecurityException("Hay problema al buscar las iniciativas de "+correo);
		}
	}
	
	/**
	 * Consulta todos los usuarios que han votado por la iniciativa
	 * @param nombreIni Nombre de la iniciativa
	 */
	@Override
	public List<Usuario> consultarVotantesxIniciativa(String nombreIni) throws ServicesException {
		try{
			return usuarioDAO.consultarVotantesxIniciativa(nombreIni);
		}catch(PersistenceException ex){
			System.err.println(ex.getMessage());
			throw  new SecurityException("Hay problema los votantes de la iniciativa "+nombreIni);
		}
	}
	/**
	 * Consulta todos los roles registrados
	 */
	@Override
	public Collection<Rol> consultarRoles() throws SecurityException {
		try{
			return Arrays.asList(Rol.values());
		}catch(PersistenceException ex){
			System.err.println(ex.getMessage());
			throw  new SecurityException("Error al consultar los roles");
		}
	}
	
	/**
	 * Consulta los intereses de una iniciativa
	 * @param nombreIniciativa
	 */
	@Override
	public Collection<Interes> consultarInteresesxIniciativa(String nombreIniciativa) throws ServicesException {
		try{
			return interesDAO.consultarInteresesxIniciativa(nombreIniciativa);
		}catch(PersistenceException ex){
			System.err.println(ex.getMessage());
			throw  new SecurityException("Error al consultar los intereses de la iniciativa "+nombreIniciativa);
		}
	}
	
	
	/**
	 * Agrega un comentario dado el nombre de la iniciativa
	 * @param nombreIniciativa
	 * @param comentario Comentario que se va a agregar
	 */
	@Override
	public void agregarComentarioxIniciativa(String nombreIniciativa, Comentario comentario) throws ServicesException {
		try{
			comentarioDAO.agregarComentarioxIniciativa(nombreIniciativa, comentario);
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al agregar el comentario a la iniciativa "+nombreIniciativa);
		}
	}
	
	
	/**
	 * Consulta los comentarios de una iniciativa
	 * @param nombreIniciativa
	 */
	@Override
	public List<Comentario> consultarComentariosxIniciativa(String nombreIniciativa) throws ServicesException {
		try{
			return comentarioDAO.consultarComentariosxIniciativa(nombreIniciativa);
		}catch(PersistenceException ex){
			System.err.println(ex.getMessage());
			throw  new SecurityException("Error al consultar los comentarios de la iniciativa "+nombreIniciativa);
		}
	}
	
}
