package edu.eci.pdsw.view;

import edu.eci.pdsw.entities.Comentario;
import edu.eci.pdsw.entities.Estado;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import edu.eci.pdsw.entities.Iniciativa;
import edu.eci.pdsw.entities.Usuario;
import edu.eci.pdsw.samples.services.ServicesException;
import edu.eci.pdsw.samples.services.ServicesIdeas;
import edu.eci.pdsw.samples.services.impl.ServicesIdeasImpl;
import java.util.Arrays;

@SuppressWarnings("deprecation")
@ManagedBean(name = "iniciativaBean")
@RequestScoped
public class IniciativaBean extends BasePageBean {

    @ManagedProperty(value = "#{param.nombre}")
    private String nombre;
    private String descripcion;
    private Usuario autor;
    private ArrayList<String> claves;    
    private String clavesUnidas;
    
    private List<Iniciativa> iniciativas;
    private Iniciativa selectIniciativa;
    private String input;
    
    
    private static final long serialVersionUID = 3594009161252782831L;

    @Inject
    private ServicesIdeas services;

    public void save() {
    	try {
    		clavesUnidas = clavesUnidas.replace(" ","");
    		claves = (ArrayList<String>) Arrays.asList(clavesUnidas.split("#"));
			services.crearIniciativa(new Iniciativa(nombre, descripcion, autor, claves));
		} catch (ServicesException e) {
			e.printStackTrace();
		}
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getClavesUnidas() {
    	return clavesUnidas;
    }
    
    public void setClavesUnidas(String clavesUnidas) {
    	this.clavesUnidas=clavesUnidas;
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void getDatas() throws ServicesException {
        try {
            iniciativas = new ArrayList(services.consultarIniciativasxClaves(claves));
        } catch (ServicesException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Iniciativa> getIniciativas() {
        return iniciativas;
    }

    public void setIniciativas(List<Iniciativa> iniciativas) {
        this.iniciativas = iniciativas;
    }

    public Iniciativa getSelectIniciativa() {

        return selectIniciativa;
    }

    public void setSelectIniciativa(Iniciativa selectIniciativa) {
        this.selectIniciativa = selectIniciativa;
    }

    public void cambioEstado(String nombre, int posi) throws ServicesException {
        List<Estado> pos = Arrays.asList(Estado.class.getEnumConstants());
        System.out.println(nombre + pos.get(posi) + "" + "yowis");
        services.modificarEstado(nombre, pos.get(posi));

    }

    public List<Iniciativa> inivs() throws ServicesException {
        return (List<Iniciativa>) services.consultarIniciativas();
    }

    public List<Iniciativa> getPrueba() throws ServicesException {
        List<Iniciativa> tmp;
        try {
            tmp = (List<Iniciativa>) services.consultarIniciativas();
            return tmp;
        } catch (ServicesException e) {
            throw new ServicesException("ERROR AL TOMAR LA INICIATIVA");

        }

    }
  
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        System.out.println("Remplace " + input);
        this.input = input.replaceAll("_", " ");
    }

    public List<Comentario> getComentarios() throws ServicesException {
        System.out.println("Input" + input);
        System.out.println(services.consultarComentariosxIniciativa(input));
        return (List<Comentario>) services.consultarComentariosxIniciativa(input);
    }

    public List<Estado> getTypes() {
        return Arrays.asList(Estado.class.getEnumConstants());
    }

    public List<String> getClaves() {
        return claves;

    }

    public void votar(String correo, String iniciativa) throws ServicesException {
        services.agregarVotanteAIniciativa(correo, iniciativa);
    }

    public boolean yaVoto(String correo, String iniciativa) throws ServicesException {
        ArrayList<Usuario> votantes = (ArrayList<Usuario>) services.consultarVotantesxIniciativa(iniciativa);
        boolean flag = false;
        for (int i = 0; i < votantes.size() && !flag; i++) {
            if (votantes.get(i).getCorreo().equals(correo)) {
                flag = true;
            }
        }
        return flag;
    }

    public int votos(String nombre) throws ServicesException {
        return services.consultarCantidadVotos(nombre);
    }

    public void setClaves(ArrayList<String> claves) {
        if (claves == null) {
            this.claves = new ArrayList<String>();
        }else{
            this.claves = claves;
        }
    }

}



