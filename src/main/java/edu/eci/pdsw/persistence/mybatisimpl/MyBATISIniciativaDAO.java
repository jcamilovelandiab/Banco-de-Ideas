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
	public int consultarCantidadVotos(String nombreIni) throws PersistenceException {
		return iniciativaMapper.consultarCantidadVotos(nombreIni);
	}

	@Override
	public List<Usuario> consultarInteresados(String nombreIni) throws PersistenceException {
		return iniciativaMapper.consultarInteresados(nombreIni);
	}

	@Override
	public void modificarEstado(String nombreIniciativa, Estado estado) throws PersistenceException {
		iniciativaMapper.modificarEstado(nombreIniciativa,estado);
	}

	@Override
	public void agregarPalabraClave(String nombreIni, String desc) {
		iniciativaMapper.agregarPalabraClave(nombreIni, desc);
		
	}

	@Override
	public List<Iniciativa> consultarIniciativasOrdenNombre() throws PersistenceException {
		return iniciativaMapper.consultarIniciativasOrdenNombre();
	}

	@Override
	public List<Iniciativa> consultarIniciativasOrdenFecha() throws PersistenceException {
		return iniciativaMapper.consultarIniciativasOrdenFecha();
	}

	@Override
	public List<Iniciativa> consultarIniciativasOrdenDescripcion() throws PersistenceException {
		return iniciativaMapper.consultarIniciativasOrdenDescripcion();
	}

	@Override
	public List<Iniciativa> consultarIniciativasOrdenEstado() throws PersistenceException {
		return iniciativaMapper.consultarIniciativasOrdenEstado();
	}

	@Override
	public List<Iniciativa> consultarIniciativasOrdenFechaFin() throws PersistenceException {
		return iniciativaMapper.consultarIniciativasOrdenFechaFin();
	}

	@Override
	public List<Iniciativa> consultarIniciativas() throws PersistenceException {
		return iniciativaMapper.consultarIniciativas();
	}

}
