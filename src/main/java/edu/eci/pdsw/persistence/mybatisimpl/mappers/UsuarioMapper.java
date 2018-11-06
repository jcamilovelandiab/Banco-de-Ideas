/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.mybatisimpl.mappers;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.entities.*;

/**
 *
 * @author HailYowis
 */
public interface  UsuarioMapper {

	public void crearUsuario(@Param("usr") Usuario usr);
	public Usuario consultarUsuario(@Param("email")String email);
	public List<Usuario> consultarUsuarios();
    public boolean autenticarUsuario(@Param("usr")Usuario usr);
    
    public void votarxIniciativa(@Param("usr")Usuario usr, @Param("ini")Iniciativa ini);
    public void cancelarVotoIniciativa(@Param("usr")Usuario usr, @Param("ini")Iniciativa ini);
    public void mostrarInteresxIniciativa(@Param("usr")Usuario usr, @Param("ini")Iniciativa ini,@Param("interes")Interes interes);
    
}
