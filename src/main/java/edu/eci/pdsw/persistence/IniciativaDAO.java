package edu.eci.pdsw.persistence;
import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.entities.*;

public interface IniciativaDAO {
	
    public void crearIniciativa(Iniciativa iniciativa) throws PersistenceException;
    public Iniciativa consultarIniciativa(long idIniciativa) throws PersistenceException;
    public List<Iniciativa> consultarIniciativas(String orden) throws PersistenceException;
    public List<Iniciativa> consultarIniciativasRelacionadas(Iniciativa iniciativa) throws PersistenceException;
    public List<Iniciativa> consultarIniciativasxClaves(List<String> palabrasClave) throws PersistenceException;
    public List<Iniciativa> consultarIniciativasxEstado(Estado estado) throws PersistenceException;
    
    public void agregarComentario(Usuario usuario, Iniciativa iniciativa, Comentario comentario) throws PersistenceException;
    public int consultarCantidadVotos(long idIniciativa) throws PersistenceException;
    public List<Usuario> consultarInteresados(long idIniciativa) throws PersistenceException;
    public void modificarEstado(long idIniciativa, Estado estado) throws PersistenceException;
    public void agregarPalabraClave(long ini,String desc) throws PersistenceException;
}
