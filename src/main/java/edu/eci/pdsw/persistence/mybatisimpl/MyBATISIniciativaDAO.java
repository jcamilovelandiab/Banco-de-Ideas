package edu.eci.pdsw.persistence.mybatisimpl;
import com.google.inject.Inject;

import edu.eci.pdsw.entities.Comentario;
import edu.eci.pdsw.entities.Estado;
import edu.eci.pdsw.entities.Iniciativa;
import edu.eci.pdsw.entities.Usuario;
import edu.eci.pdsw.persistence.*;
import edu.eci.pdsw.persistence.mybatisimpl.mappers.IniciativaMapper;

import java.util.*;

import org.apache.ibatis.exceptions.PersistenceException;
public class MyBATISIniciativaDAO implements IniciativaDAO {
	
	
	@Inject
     private IniciativaMapper iniciativaMapper;

	@Override
	public void crearIniciativa(Iniciativa iniciativa) throws PersistenceException {
		iniciativaMapper.crearIniciativa(iniciativa);
	}

	@Override
	public Iniciativa consultarIniciativa(String nombreIniciativa) throws PersistenceException {
		return iniciativaMapper.consultarIniciativa(nombreIniciativa);
	}

	@Override
	public List<Iniciativa> consultarIniciativas(String orden) throws PersistenceException {
		return iniciativaMapper.consultarIniciativas(orden);
	}

	@Override
	public List<Iniciativa> consultarIniciativasRelacionadas(Iniciativa iniciativa) throws PersistenceException {
		return iniciativaMapper.consultarIniciativasRelacionadas(iniciativa);
	}

	@Override
	public List<Iniciativa> consultarIniciativasxClaves(String palabraClave) throws PersistenceException {
		return iniciativaMapper.consultarIniciativasxClaves(palabraClave);
	}

	@Override
	public List<Iniciativa> consultarIniciativasxEstado(Estado estado) throws PersistenceException {
		return iniciativaMapper.consultarIniciativasxEstado(estado);
	}

	@Override
	public void agregarComentario(Usuario usuario, Iniciativa iniciativa, Comentario comentario)
			throws PersistenceException {
		iniciativaMapper.agregarComentario(usuario, iniciativa, comentario);		
	}

	@Override
	public int consultarCantidadVotos(long idIniciativa) throws PersistenceException {
		return iniciativaMapper.consultarCantidadVotos(idIniciativa);
	}

	@Override
	public List<Usuario> consultarInteresados(long idIniciativa) throws PersistenceException {
		return iniciativaMapper.consultarInteresados(idIniciativa);
	}

	@Override
	public void modificarEstado(String nombreIniciativa, Estado estado) throws PersistenceException {
		iniciativaMapper.modificarEstado(nombreIniciativa,estado);
	}

	@Override
	public void agregarPalabraClave(String nombreIni, String desc) {
		iniciativaMapper.agregarPalabraClave(nombreIni, desc);
		
	}  

}
