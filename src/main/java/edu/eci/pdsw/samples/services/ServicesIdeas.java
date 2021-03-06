package edu.eci.pdsw.samples.services;


import java.io.File;
import java.util.Collection;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.pdsw.entities.*;

public interface ServicesIdeas { 

    
	public void crearIniciativa(Iniciativa iniciativa) throws ServicesException; //
    public Iniciativa consultarIniciativa(String nombreIniciativa) throws ServicesException; //
    public Collection<Iniciativa> consultarIniciativas() throws ServicesException; //
    public Collection<Iniciativa> consultarIniciativasRelacionadas(String nombreIni) throws ServicesException; //
    public List<Iniciativa> consultarIniciativasxArea(int area) throws PersistenceException;
    public Collection<Iniciativa> consultarIniciativasxClaves(List<String> palabrasClave) throws ServicesException; //
    public Collection<Iniciativa> consultarIniciativasxEstado(String estado) throws ServicesException; //
    public Collection<Iniciativa> consultarIniciativasxOrden(String orden) throws ServicesException;  //
    public Collection<Iniciativa> consultarIniciativasxProponente(String correo) throws ServicesException; //
    
    public void agregarComentarioxIniciativa(String nombreIniciativa, Comentario comentario) throws ServicesException; //
    public Collection<Comentario> consultarComentariosxIniciativa(String nombreIniciativa) throws ServicesException; //
    public int consultarCantidadVotos(String nombreIni) throws ServicesException; //
    
    public void modificarEstado(String nombreIniciativa, Estado estado) throws ServicesException; //
    
    public void crearUsuario(Usuario usuario) throws ServicesException; //
    public Usuario consultarUsuario(String correo) throws ServicesException; //
    public Collection<Usuario>consultarUsuarios() throws ServicesException; //
    
	public boolean autenticarUsuario(Usuario usuario) throws ServicesException;
	public void agregarVotanteAIniciativa(String correo, String nombreIni) throws ServicesException; //
	public void eliminarVotanteAIniciativa(String correo, String nombreIni) throws ServicesException; //
	public Collection<Usuario> consultarVotantesxIniciativa(String nombreIni) throws ServicesException; //
	
	public void usuarioMuestraInteresxIniciativa(String nombreIniciativa, Interes interes) throws ServicesException; //
	public Collection<Interes> consultarInteresesxIniciativa(String nombreIniciativa) throws ServicesException; //
	public Collection<Interes> consultarInteresesxUsuario(String correo) throws ServicesException; //
	
	public void asignarPerfil(String correoUsuario, Rol tipo) throws ServicesException; //
	public File consultarEstadisticas() throws ServicesException; 
	public int existeUsuario(String correo) throws SecurityException; //
    public Collection<Rol> consultarRoles() throws SecurityException; //
    
    public void modificarIniciativaxEstado(String nombreIniciativa, String nuevaDescripcion) throws SecurityException;
}