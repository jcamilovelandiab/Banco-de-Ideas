package edu.eci.pdsw.view;

import edu.eci.pdsw.entities.Comentario;
import edu.eci.pdsw.entities.Estado;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.eci.pdsw.entities.Iniciativa;
import edu.eci.pdsw.entities.Usuario;
import edu.eci.pdsw.samples.services.ServicesException;
import edu.eci.pdsw.samples.services.ServicesIdeas;
import edu.eci.pdsw.samples.services.impl.ServicesIdeasImpl;
import java.util.Arrays;
import javax.annotation.PostConstruct;

@SuppressWarnings("deprecation")
@ManagedBean(name = "iniciativaBean")
@SessionScoped
public class IniciativaBean extends BasePageBean {
        
    private String nombre;
    private String descripcion;
    private Usuario autor;
    private List<String> claves;    
    private String clavesUnidas;
    private BarChartModel bar;
    private List<Iniciativa> iniciativas;
    private Iniciativa selectIniciativa;
    private String input;
    
    
    private static final long serialVersionUID = 3594009161252782831L;

    @Inject
    private ServicesIdeas services;

    public void save(String correo) {
    	try {
    		
    		//System.out.println("AQUI LLEGOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO -> <"+correo+">");
    		autor = services.consultarUsuario(correo);
    		if(autor!=null) {
    			
    			//System.out.println(autor);
        		clavesUnidas = clavesUnidas.replace(" ","");
        		claves = Arrays.asList(clavesUnidas.split("#"));
        		//System.out.println("INICIATIVA BEAN "+autor);
    			services.crearIniciativa(new Iniciativa(nombre, descripcion, autor, claves));
    		}
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
        this.input = input.replaceAll("_", " ");
    }

    public List<Comentario> getComentarios(String input) throws ServicesException {
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

    public void votar(String iniciativa) throws ServicesException {
        String correo = ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("correo").toString();
        if(iniciativa.equals(""))return;
        if (!isVoto(iniciativa))services.agregarVotanteAIniciativa(correo, iniciativa);
    }
    public void dislike(String iniciativa)throws ServicesException{
        String correo = ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("correo").toString();
        if (isVoto(iniciativa)) services.eliminarVotanteAIniciativa(correo, iniciativa);
        
    }
    public List<Iniciativa> mias(String correo) throws ServicesException{
    	//String correo = ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("correo").toString();
        return (List<Iniciativa>) services.consultarIniciativasxProponente(correo);
    }
    




    public boolean isVoto(String iniciativa) throws ServicesException {

    	String correo = ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("correo").toString();
        System.out.println("Entre "+ correo + " " + iniciativa);
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

    public void setPrueba(){
        System.out.println("Funciona el click");
    }

    public void setClaves(ArrayList<String> claves) {
        if (claves == null) {
            this.claves = new ArrayList<String>();
        }else{
            this.claves = claves;
        }
    }
    public int solucionado() throws ServicesException{
        int a;
       a=services.consultarIniciativasxEstado("SOLUCIONADO").size();
       return a;
    } 
    public int espera() throws ServicesException{
        int a;
       a=services.consultarIniciativasxEstado("EN_ESPERA").size();
       return a;
    } 
    public int revision() throws ServicesException{
        int a;
       a=services.consultarIniciativasxEstado("EN_REVISION").size();
       return a;
    } 
    public int proyecto() throws ServicesException{
        int a;
       a=services.consultarIniciativasxEstado("PROYECTO").size();
       return a;
    } 
    public int desechado() throws ServicesException{
        int a;
       a=services.consultarIniciativasxEstado("DESECHADO").size();
       return a;
    } 
     public int areaP() throws ServicesException{
        int a;
       a=services.consultarIniciativasxArea(1).size();
       return a;
    } 
      public int areaD() throws ServicesException{
        int a;
       a=services.consultarIniciativasxArea(2).size();
       return a;
    } 

      public Iniciativa consultarIniciativa(String nombre) throws ServicesException{
          System.out.println(nombre+"  "+"a veces me sorprendo lo makia que soy o lo marika");
          return services.consultarIniciativa(nombre);
      }
      public List<Iniciativa> iniciativasEspera() throws ServicesException{
          return (List<Iniciativa>) services.consultarIniciativasxEstado("EN_ESPERA");
      }
}

