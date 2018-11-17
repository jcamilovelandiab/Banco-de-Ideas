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
		iniciativa.setNombre(iniciativa.getNombre().toLowerCase());
		iniciativaMapper.crearIniciativa(iniciativa);
	}

	@Override
	public Iniciativa consultarIniciativa(String nombreIniciativa) throws PersistenceException {
		return iniciativaMapper.consultarIniciativa(nombreIniciativa.toLowerCase());
	}

	@Override
	public List<Iniciativa> consultarIniciativasRelacionadas(String nombreIni) throws PersistenceException {
		return iniciativaMapper.consultarIniciativasRelacionadas(nombreIni.toLowerCase());
	}

	@Override
	public List<Iniciativa> consultarIniciativasxClaves(String palabraClave) throws PersistenceException {
		return iniciativaMapper.consultarIniciativasxClaves(palabraClave.toLowerCase());
	}

	@Override
	public List<Iniciativa> consultarIniciativasxEstado(Estado estado) throws PersistenceException {
		return iniciativaMapper.consultarIniciativasxEstado(estado);
	}

	@Override
	public void modificarEstado(String nombreIniciativa, Estado estado) throws PersistenceException {
		iniciativaMapper.modificarEstado(nombreIniciativa.toLowerCase(),estado);
	}

	@Override
	public void agregarPalabraClave(String nombreIni, String desc) {
		iniciativaMapper.agregarPalabraClave(nombreIni.toLowerCase(), desc);
		
	}

	@Override
	public List<Iniciativa> consultarIniciativas() throws PersistenceException {
		return iniciativaMapper.consultarIniciativas();
	}

	@Override
	public List<Iniciativa> consultarIniciativasxOrden(String orden) throws PersistenceException {
		return iniciativaMapper.consultarIniciativasxOrden(orden.toLowerCase());
	}

	@Override
	public List<Iniciativa> consultarIniciativasxProponente(String correo){
		return iniciativaMapper.consultarIniciativasxProponente(correo.toLowerCase());
	}

	
	
	/**
	 * Un usuario desmuestra Afinidad o gusto por una Iniciativa
	 * Se le agrega un votante
	 * 
	 * @param usuario Usuario que vota
	 * @param iniciativa El usario vota por esta iniciativa
	 * @votar votar muestra si le gusta la iniciativa o si quiere quitar su voto por la iniciativa
	 */
	@Override
	public void agregarVotanteAIniciativa(String correo, String nombreIni) {
		iniciativaMapper.agregarVotanteAIniciativa(correo.toLowerCase(), nombreIni.toLowerCase());
	}

	@Override
	public void eliminarVotanteAIniciativa(String correo, String nombreIni) throws PersistenceException {
		iniciativaMapper.eliminarVotanteAIniciativa(correo.toLowerCase(), nombreIni.toLowerCase());
	}
	
}
