/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.mybatisimpl.mappers;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.entities.*;
/**
 *
 * @author HAILYOWIS
 */
public interface  IniciativaMapper {

    public void crearIniciativa(@Param("ini")Iniciativa ini);
    
    public Iniciativa consultarIniciativa(@Param("idIni") long  idIni);
    
    public List<Iniciativa> consultarIniciativas(@Param("orden")String orden);
    
    public List<Iniciativa> consultarIniciativasRelacionadas(@Param("ini")Iniciativa ini);
    
    public List<Iniciativa> consultarIniciativasxClaves(@Param("clave")String palabraClave);
    
    public List<Iniciativa> consultarIniciativasxEstado(@Param("estado")Estado estado);
    
    public void agregarComentario(@Param("usr")Usuario usr, 
    		@Param("ini")Iniciativa ini,
    		@Param("comentario")Comentario comentario);
    
    public int consultarCantidadVotos(@Param("idIni") long idIni);
    
    public List<Usuario> consultarInteresados(@Param("idIni") long idIni);
    
    public void modificarEstado(@Param("idIni")long ini, 
    		@Param("estado") Estado estado);
    
    public void agregarPalabraClave(@Param("idIni")long ini,
    		@Param("descripcion") String desc);
     
}
