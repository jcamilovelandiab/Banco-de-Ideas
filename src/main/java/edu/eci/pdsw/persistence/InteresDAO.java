package edu.eci.pdsw.persistence;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.entities.Interes;

public interface InteresDAO {

	public List<Interes> consultarInteresesxProponente(String correo) throws PersistenceException;
	public void usuarioMuestraInteresAIniciativa(String correo, String nombreIni) throws PersistenceException;
	
}
