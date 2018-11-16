package edu.eci.pdsw.persistence;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.entities.Interes;

public interface InteresDAO {

	public List<Interes> consultarInteresesxUsuario(String correo) throws PersistenceException;
	public void usuarioMuestraInteresxIniciativa(String nombreIniciativa, Interes interes) throws PersistenceException;
	public List<Interes> consultarInteresesxIniciativa(String nombreIni) throws PersistenceException;
	
}
