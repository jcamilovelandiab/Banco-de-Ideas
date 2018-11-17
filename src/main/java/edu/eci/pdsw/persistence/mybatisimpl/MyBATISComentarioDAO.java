package edu.eci.pdsw.persistence.mybatisimpl;

import java.util.List;
import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.entities.Comentario;
import edu.eci.pdsw.persistence.ComentarioDAO;
import edu.eci.pdsw.persistence.mybatisimpl.mappers.ComentarioMapper;
import edu.eci.pdsw.persistence.mybatisimpl.mappers.IniciativaMapper;

public class MyBATISComentarioDAO implements ComentarioDAO{

	@Inject
    private ComentarioMapper comentarioMapper;
	
	@Override
	public void agregarComentarioxIniciativa(String nombreIniciativa, Comentario comentario)
			throws PersistenceException {
		comentarioMapper.agregarComentarioxIniciativa(nombreIniciativa, comentario);
	}

	@Override
	public List<Comentario> consultarComentariosxIniciativa(String nombreIniciativa) throws PersistenceException {
		return comentarioMapper.consultarComentariosxIniciativa(nombreIniciativa);
	}
	
}
