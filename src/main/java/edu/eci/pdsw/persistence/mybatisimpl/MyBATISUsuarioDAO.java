package edu.eci.pdsw.persistence.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.pdsw.entities.Iniciativa;
import edu.eci.pdsw.entities.Interes;
import edu.eci.pdsw.entities.Rol;
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
        return usuarioMapper.consultarUsuario(correo.toLowerCase());
    }

    
    /**
     * Crea un usuario
     */
	@Override
	public void crearUsuario(Usuario usuario) throws PersistenceException {
		 usuario.setCorreo(usuario.getCorreo().toLowerCase());
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


	@Override
	public File consultarEstadisticas() throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void asignarPerfil(String correoUsuario, Rol tipo) throws PersistenceException {
		usuarioMapper.asignarPerfil(correoUsuario.toLowerCase(), tipo);
	}


	@Override
	public int existeUsuario(String correo) throws PersistenceException {
		return usuarioMapper.existeUsuario(correo.toLowerCase());	
	}


	@Override
	public List<Usuario> consultarVotantesxIniciativa(String nombreIni) throws PersistenceException {
		return usuarioMapper.consultarVotantesxIniciativa(nombreIni.toLowerCase());
	}
}
