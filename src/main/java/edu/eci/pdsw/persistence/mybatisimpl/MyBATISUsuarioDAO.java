package edu.eci.pdsw.persistence.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.pdsw.entities.Iniciativa;
import edu.eci.pdsw.entities.Interes;
import edu.eci.pdsw.entities.Usuario;
import edu.eci.pdsw.persistence.UsuarioDAO;
import edu.eci.pdsw.persistence.mybatisimpl.mappers.UsuarioMapper;

import java.io.File;
import java.util.*;
import org.apache.ibatis.exceptions.PersistenceException;

public class MyBATISUsuarioDAO implements UsuarioDAO{
    
     @Inject
     private UsuarioMapper usuarioMapper;  
    
     /**
      * Consulta un usuario dado un correo
      */
    @Override
    public Usuario consultarUsuario(String correo) throws PersistenceException {
        return usuarioMapper.consultarUsuario(correo);
    }

    
    /**
     * Crea un usuario
     */
	@Override
	public void crearUsuario(Usuario usuario) throws PersistenceException {
	     usuarioMapper.crearUsuario(usuario);       
	}

	
	/**
	 * Consulta todos los usuarios
	 */
	@Override
    public List<Usuario> consultarUsuarios() throws PersistenceException {
		return  usuarioMapper.consultarUsuarios();
    }
	
	/**
	 * Verifica la autenticacion del usuario
	 */
	@Override
	public boolean autenticarUsuario(Usuario usuario) throws PersistenceException{
		return usuarioMapper.autenticarUsuario(usuario);
	}

	

	/**
	 * Un usuario desmuestra Afinidad o gusto por una Iniciativa
	 * 
	 * @param usuario Usuario que vota
	 * @param iniciativa El usario vota por esta iniciativa
	 * @votar votar muestra si le gusta la iniciativa o si quiere quitar su voto por la iniciativa
	 */
	@Override
	public void votarxIniciativa(Usuario usuario, Iniciativa iniciativa) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	
	

	/**
	 * Un usuario demuestra el interes a una iniciativa
	 */
	@Override
	public void mostrarInteresxIniciativa(Usuario usuario, Iniciativa iniciativa, Interes interes)
			throws PersistenceException {
		usuarioMapper.mostrarInteresxIniciativa(usuario, iniciativa, interes);		
	}

	
	@Override
	public void cancelarVotoIniciativa(Usuario usuario, Iniciativa iniciativa) throws PersistenceException {
		usuarioMapper.cancelarVotoIniciativa(usuario, iniciativa);		
	}

	@Override
	public File consultarEstadisticas() throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}
}
