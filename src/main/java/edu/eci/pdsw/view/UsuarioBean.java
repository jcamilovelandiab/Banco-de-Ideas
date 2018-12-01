package edu.eci.pdsw.view;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import edu.eci.pdsw.samples.services.ServicesException;
import edu.eci.pdsw.samples.services.ServicesIdeas;
import edu.eci.pdsw.samples.services.impl.*;

import edu.eci.pdsw.entities.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;

@SuppressWarnings("deprecation")
@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean extends BasePageBean {

    @ManagedProperty(value = "#{param.correo}")
    private String correo;
    private Usuario sr;
    private static final long serialVersionUID = 3594009161252782831L;

    @Inject
    private ServicesIdeas services;
    private String opcion;
    private String rol;
    private List<String> roles;

    public List<Rol> getTypes() {
        return Arrays.asList(Rol.class.getEnumConstants());
    }

    public void changeRol(String correo, int i) throws ServicesException {
        List<Rol> pos = Arrays.asList(Rol.class.getEnumConstants());
        System.out.println(correo + pos.get(i) + "   " + i + "  " + "yowis");
        services.asignarPerfil(correo, pos.get(i));
    }

   
    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getOpcion() {
        return this.opcion;
    }

    public String getCorreo() {
        System.out.println(correo);
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Usuario getUsuario() throws ServicesException {
        try {
            sr = services.consultarUsuario(this.correo);
        } catch (ServicesException e) {
            e.getMessage();
        }
        return sr;
    }

    /*public List<Iniciativas> getBuscar(){
            return services.consulta
            
        }*/
    public List<Usuario> usr() throws ServicesException {
        System.out.println(services.consultarUsuarios());
        return (List<Usuario>) services.consultarUsuarios();
    }
    
   


}
