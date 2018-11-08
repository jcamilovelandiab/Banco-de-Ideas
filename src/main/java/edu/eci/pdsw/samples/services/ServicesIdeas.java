package edu.eci.pdsw.samples.services;


import java.io.File;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.entities.*;


public interface ServicesIdeas { 
    
	public void crearIniciativa(Iniciativa iniciativa) throws ServicesException;
    
    public Iniciativa consultarIniciativa(String nombreIniciativa) throws ServicesException;
    public Collection<Iniciativa> consultarIniciativas(String orden) throws ServicesException;
    public Collection<Iniciativa> consultarIniciativasRelacionadas(Iniciativa iniciativa) throws ServicesException;
    public Collection<Iniciativa> consultarIniciativasxClaves(List<String> palabrasClave) throws ServicesException;
    public Collection<Iniciativa> consultarIniciativasxEstado(Estado estado) throws ServicesException;
    
    public void agregarComentario(Usuario usuario, Iniciativa iniciativa, Comentario comentario) throws ServicesException;
    public int consultarCantidadVotos(String nombreIni) throws ServicesException;
    public Collection<Usuario> consultarInteresados(String nombreIni) throws ServicesException;
    public void modificarEstado(String nombreIniciativa, Estado estado) throws ServicesException;
    
    
    public void crearUsuario(Usuario usuario) throws ServicesException;
    public Usuario consultarUsuario(String correo) throws ServicesException;
    public Collection<Usuario>consultarUsuarios() throws ServicesException;
	public boolean autenticarUsuario(Usuario usuario) throws ServicesException;
	 
	public void votarxIniciativa(String correoUsuario, String nombreIniciativa) throws ServicesException;
	public void cancelarVotoIniciativa(String correoUsuario, String nombreIniciativa) throws ServicesException; 
	public void mostrarInteresxIniciativa(String correoUsuario, String nombreIniciativa, Interes interes) throws ServicesException;
	
	public void asignarPerfil(String correoUsuario, Rol tipo) throws ServicesException;
	public File consultarEstadisticas() throws ServicesException;

	public int existeUsuario(String correo) throws SecurityException;
    

}