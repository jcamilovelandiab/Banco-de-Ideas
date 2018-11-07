package edu.eci.pdsw.samples.services;


import java.io.File;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.entities.*;


public interface ServicesIdeas { 
    
	public void crearIniciativa(Iniciativa iniciativa) throws ServicesException;
    
    public Iniciativa consultarIniciativa(long idIniciativa) throws ServicesException;
    public List<Iniciativa> consultarIniciativas(String orden) throws ServicesException;
    public List<Iniciativa> consultarIniciativasRelacionadas(Iniciativa iniciativa) throws ServicesException;
    public List<Iniciativa> consultarIniciativasxClaves(List<String> palabrasClave) throws ServicesException;
    public List<Iniciativa> consultarIniciativasxEstado(Estado estado) throws ServicesException;
    
    public void agregarComentario(Usuario usuario, Iniciativa iniciativa, Comentario comentario) throws ServicesException;
    public int consultarCantidadVotos(long idIniciativa) throws ServicesException;
    public List<Usuario> consultarInteresados(long idIniciativa) throws ServicesException;
    public void modificarEstado(long idIniciativa, Estado estado) throws ServicesException;
    
    
    public void crearUsuario(Usuario usuario) throws ServicesException;
    public Usuario consultarUsuario(String correo) throws ServicesException;
    public List<Usuario>consultarUsuarios() throws ServicesException;
	public boolean autenticarUsuario(Usuario usuario) throws ServicesException;
	 
	public void votarxIniciativa(String correoUsuario, long idIniciativa) throws ServicesException;
	public void cancelarVotoIniciativa(String correoUsuario, long idIniciativa) throws ServicesException; 
	public void mostrarInteresxIniciativa(String correoUsuario, long idIniciativa, Interes interes) throws ServicesException;
	
	public void asignarPerfil(String correoUsuario, Rol tipo) throws ServicesException;
	public File consultarEstadisticas() throws ServicesException;

	public int existeUsuario(String correo) throws SecurityException;
    

}