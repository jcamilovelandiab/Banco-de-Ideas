package edu.eci.pdsw.persistence.mybatisimpl.mappers;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.entities.Interes;

public interface InteresMapper {

	public List<Interes> consultarInteresesxUsuario(@Param("correo") String correo) throws PersistenceException;
	
	public void usuarioMuestraInteresxIniciativa(@Param("nombreIni")String nombreIni, @Param("interes")Interes interes) throws PersistenceException;
	
	public List<Interes> consultarInteresesxIniciativa(@Param("nombreIni") String nombreIni) throws PersistenceException;

}