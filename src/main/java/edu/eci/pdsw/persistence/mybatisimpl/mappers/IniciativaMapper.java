/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.mybatisimpl.mappers;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.entities.*;

public interface  IniciativaMapper {

    public void crearIniciativa(@Param("ini")Iniciativa ini);
    
    public Iniciativa consultarIniciativa(@Param("nombreIni")String  nombreIni); //
    
    public List<Iniciativa> consultarIniciativas(); //
    
    public List<Iniciativa> consultarIniciativasxOrden(@Param("orden")String orden); //
    public List<Iniciativa> consultarIniciativasxClaves(@Param("clave")String clave); //
    public List<Iniciativa> consultarIniciativasxEstado(@Param("estado")String estado);
    public List<Iniciativa> consultarIniciativasxProponente(@Param("correo")String correo); //
    
    public void agregarVotanteAIniciativa(@Param("correo")String correo, @Param("nombreIni")String nombreIni);
    public void eliminarVotanteAIniciativa(@Param("correo")String correo, @Param("nombreIni")String nombreIni);
    
    public void agregarComentario(@Param("usr")Usuario usr, 
    		@Param("ini")Iniciativa ini,
    		@Param("comentario")Comentario comentario);
    
    public void modificarEstado(@Param("nombreIni")String nombreIniciativa, 
    		@Param("estado") Estado estado);
    
    public void agregarPalabraClave(@Param("nombreIni")String nombreIni,
    		@Param("descripcion") String desc);
   
    public void modificarIniciativaxEstado(@Param("nombreIni")String nombreIniciativa,@Param("nuevaDescripcion") String nuevaDescripcion);

    public List<Iniciativa> consultarIniciativasxArea(@Param("area") int area);
   
}
