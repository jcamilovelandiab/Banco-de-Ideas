package edu.eci.pdsw.persistence;
import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.entities.*;

public interface  UsuarioDAO {
    public void crearUsuario(Usuario usuario) throws PersistenceException;
    public Usuario consultarUsuario(String correo) throws PersistenceException;
    public List<Usuario>consultarUsuarios() throws PersistenceException;
	public boolean autenticarUsuario(Usuario usuario) throws PersistenceException;
	 
	public void votarxIniciativa(Usuario usuario, Iniciativa iniciativa) throws PersistenceException;
	public void cancelarVotoIniciativa(Usuario usuario, Iniciativa iniciativa) throws PersistenceException; 
	public void mostrarInteresxIniciativa(Usuario usuario, Iniciativa iniciativa, Interes interes) throws PersistenceException;
	public File consultarEstadisticas() throws PersistenceException;
	
}
