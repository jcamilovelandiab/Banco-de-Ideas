package edu.eci.pdsw.samples.services.impl;

import java.io.File;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.entities.*;
import edu.eci.pdsw.persistence.*;
import edu.eci.pdsw.samples.services.*;


public class IdeasServicesImpl  implements IdeasServices{
	
	@Inject
	private UsuarioDAO usuarioDAO;
	@Inject
	private IniciativaDAO iniciativaDAO;
	
	@Override
	public void crearIniciativa(Iniciativa iniciativa) throws ServicesException {
		try{
			iniciativaDAO.crearIniciativa(iniciativa);
		}catch(PersistenceException  ex) {
			throw new ServicesException("Error al crear una iniciativa");
		}
	}
	
	@Override
	public Iniciativa consultarIniciativa(long idIniciativa) throws ServicesException {
		try {
			return iniciativaDAO.consultarIniciativa(idIniciativa);
		}catch(PersistenceException  ex) {
			throw new ServicesException("Error al consultar la iniciativa "+idIniciativa);
		}
	}
	
	@Override
	public List<Iniciativa> consultarIniciativas(String orden) throws ServicesException {
		try{
			return iniciativaDAO.consultarIniciativas(orden);
		}catch(PersistenceException  ex) {
			throw new ServicesException("Error al consultar todas las iniciativas");
		}
	}
	
	@Override
	public List<Iniciativa> consultarIniciativasRelacionadas(Iniciativa iniciativa) throws ServicesException {
		try{
			return iniciativaDAO.consultarIniciativasRelacionadas(iniciativa);
		}catch(PersistenceException  ex) {
			throw new ServicesException("Error al consultar iniciativas relacionadas de "+iniciativa.getNo_iniciativa());
		}
	}
	
	@Override
	public List<Iniciativa> consultarIniciativasxClaves(List<String> palabrasClave) throws ServicesException {
		try{
			return iniciativaDAO.consultarIniciativasxClaves(palabrasClave);
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
			throw new ServicesException("Error al agregar el comentario a la iniciativa "+iniciativa.getNo_iniciativa());
		}
	}
	
	@Override
	public int consultarCantidadVotos(long idIniciativa) throws ServicesException {
		try{
			return iniciativaDAO.consultarCantidadVotos(idIniciativa);
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al consultar la cantidad de votos de la iniciativa "+idIniciativa);
		}
	}
	
	@Override
	public List<Usuario> consultarInteresados(long idIniciativa) throws ServicesException {
		try{
			return iniciativaDAO.consultarInteresados(idIniciativa);
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al consultar los interesados en la iniciativa "+idIniciativa);
		}
	}
	
	@Override
	public void modificarEstado(long idIniciativa, Estado estado) throws ServicesException {
		try{
			iniciativaDAO.modificarEstado(idIniciativa, estado);		
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al modificar el estado de la iniciativa "+idIniciativa);
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
	public void votarxIniciativa(Usuario usuario, Iniciativa iniciativa) throws ServicesException {
		try{
			usuarioDAO.votarxIniciativa(usuario, iniciativa);		
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al votar por la iniciativa "+iniciativa.getNo_iniciativa());
		}
	}
	
	@Override
	public void cancelarVotoIniciativa(Usuario usuario, Iniciativa iniciativa) throws ServicesException {
		try{
			usuarioDAO.cancelarVotoIniciativa(usuario, iniciativa);
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al cancelar el voto del usuario "+usuario.getNombre()+ " de la iniciativa"+iniciativa.getNo_iniciativa());
		}
	}
	
	@Override
	public void mostrarInteresxIniciativa(Usuario usuario, Iniciativa iniciativa, Interes interes) throws ServicesException {
		try{
			usuarioDAO.mostrarInteresxIniciativa(usuario, iniciativa, interes);		
		}catch(PersistenceException  e) {
			throw new ServicesException("Error al mostrar interes del usuario "+usuario.getNombre()+" por la iniciativa "+iniciativa.getNo_iniciativa());
		}
	}
	
	@Override
	public File consultarEstadisticas() throws ServicesException {
		// TODO Auto-generated method stub
		return null;
	}

}
