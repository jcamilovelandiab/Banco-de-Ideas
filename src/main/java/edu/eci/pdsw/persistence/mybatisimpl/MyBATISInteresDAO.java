package edu.eci.pdsw.persistence.mybatisimpl;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.entities.Interes;
import edu.eci.pdsw.persistence.InteresDAO;
import edu.eci.pdsw.persistence.mybatisimpl.mappers.InteresMapper;
import edu.eci.pdsw.persistence.mybatisimpl.mappers.UsuarioMapper;

public class MyBATISInteresDAO implements InteresDAO {

    @Inject
    private InteresMapper interesMapper; 
	
	@Override
	public List<Interes> consultarInteresesxProponente(String correo) throws PersistenceException {
		return interesMapper.consultarInteresesxProponente(correo);
	}

	@Override
	public void usuarioMuestraInteresxIniciativa(String nombreIni, Interes interes) throws PersistenceException {
		interesMapper.usuarioMuestraInteresxIniciativa(nombreIni, interes);
	}

	@Override
	public List<Interes> consultarInteresesxIniciativa(String nombreIni) throws PersistenceException {
		return interesMapper.consultarInteresesxIniciativa(nombreIni);
	}

}
