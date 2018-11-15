package edu.eci.pdsw.persistence.mybatisimpl;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.entities.Interes;
import edu.eci.pdsw.persistence.InteresDAO;

public class MyBATISInteresDAO implements InteresDAO {

	@Override
	public List<Interes> consultarInteresesxProponente(String correo) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void usuarioMuestraInteresAIniciativa(String correo, String nombreIni) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}

}
