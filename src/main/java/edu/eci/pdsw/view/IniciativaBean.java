package edu.eci.pdsw.view;

import edu.eci.pdsw.entities.Comentario;
import edu.eci.pdsw.entities.Estado;

import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;
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
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.eci.pdsw.entities.Iniciativa;
import edu.eci.pdsw.entities.Rol;
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
    private String correoAutor;
    private List<String> claves;    
    private String clavesUnidas;
    private BarChartModel bar;
    private List<Iniciativa> iniciativas;
    private Iniciativa selectIniciativa;
    private String input;
    
    
    private static final long serialVersionUID = 3594009161252782831L;

    @Inject
    private ServicesIdeas services;


    
    public void save() {
    	try {
    		
    		//System.out.println("AQUI LLEGOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO -> <"+correo+">");
    		correoAutor =  ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("correo").toString(); 
    		if(correoAutor!=null) {
    			
    			//System.out.println(autor);
        		clavesUnidas = clavesUnidas.replace(" ","");
        		claves = Arrays.asList(clavesUnidas.split("#"));
        		//System.out.println("INICIATIVA BEAN "+autor);
        		Usuario autor = services.consultarUsuario(correoAutor);
        		if(autor!=null){
        			System.out.println(autor.getCorreo()+ " registro iniciativa -> "+nombre);
        			services.crearIniciativa(new Iniciativa(nombre, descripcion, autor, claves));
        			if (autor.getTipo().equals(Rol.ADMINISTRADOR)) {
                        FacesContext.getCurrentInstance().getExternalContext().redirect("adminitracion.xhtml");
                    } else if (autor.getTipo().equals(Rol.PUBLICO)) {

                        FacesContext.getCurrentInstance().getExternalContext().redirect("publico.xhtml");
                    } else if (autor.getTipo().equals(Rol.PROPONENTE)) {
                        FacesContext.getCurrentInstance().getExternalContext().redirect("proponente.xhtml");
                    } else if (autor.getTipo().equals(Rol.PMO_ODI)) {
                        FacesContext.getCurrentInstance().getExternalContext().redirect("PMO.xhtml");
                    }
        			
        		}
    		}
    		nombre="";
    		descripcion="";
    		clavesUnidas="";
		} catch (ServicesException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
        return (List<Comentario>) services.consultarComentariosxIniciativa(input);
    }

    public void registrarComentario(String comen,String iniciativa) throws ServicesException {
        String correo = ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("correo").toString();
        Usuario usr  = services.consultarUsuario(correo);
        Comentario comentario = new Comentario(comen, usr);
        services.agregarComentarioxIniciativa(iniciativa,comentario);
    }


    public List<Estado> getTypes() {
        return Arrays.asList(Estado.class.getEnumConstants());
    }

    public List<String> getClaves() {
        return claves;

    }

    public void votar(String iniciativa) throws ServicesException {
    	System.out.println(iniciativa+ "---------------------------------------" );
        String correo = ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("correo").toString();
        if(iniciativa.equals(""))return;
        if (!isVoto(iniciativa))services.agregarVotanteAIniciativa(correo, iniciativa);
        else{
        	services.eliminarVotanteAIniciativa(correo, iniciativa);
        }
    }
    public void dislike(String iniciativa)throws ServicesException{
        String correo = ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("correo").toString();
        if (isVoto(iniciativa)) services.eliminarVotanteAIniciativa(correo, iniciativa);
        
    }
    public List<Iniciativa> mias() throws ServicesException{
    	String correo = ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("correo").toString();

    	return (List<Iniciativa>) services.consultarIniciativasxProponente(correo);
        
    }
    




    public boolean isVoto(String iniciativa) throws ServicesException {

    	String correo = ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("correo").toString();
       
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
      public void changeDescription(String nombre,String descripcion){
          //System.out.println("el nombre es]:  "+nombre+ "ddes"+ "  "+ descripcion);
          services.modificarIniciativaxEstado(nombre, descripcion);
      }


}

