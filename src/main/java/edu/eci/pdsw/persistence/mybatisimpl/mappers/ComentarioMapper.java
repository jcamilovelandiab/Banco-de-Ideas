package edu.eci.pdsw.persistence.mybatisimpl.mappers;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.entities.Comentario;
import edu.eci.pdsw.entities.Iniciativa;
import edu.eci.pdsw.entities.Usuario;
import edu.eci.pdsw.samples.services.ServicesException;


public interface ComentarioMapper {
	
	public void agregarComentarioxIniciativa(@Param("nombreIni") String nombreIniciativa,@Param("comentario") Comentario comentario);
    public List<Comentario> consultarComentariosxIniciativa(@Param("nombreIni") String nombreIniciativa);
    
}
