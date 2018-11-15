package edu.eci.pdsw.persistence;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.entities.*;

public interface ComentarioDAO {

	public void agregarComentarioxIniciativa(String nombreIniciativa, Comentario comentario)  throws PersistenceException;
    public List<Comentario> consultarComentariosxIniciativa(String nombreIniciativa) throws PersistenceException;
	
}
