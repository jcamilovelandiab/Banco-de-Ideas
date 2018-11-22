package edu.eci.pdsw.view;

import edu.eci.pdsw.entities.Comentario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import edu.eci.pdsw.entities.Usuario;
import edu.eci.pdsw.samples.services.ServicesException;
import edu.eci.pdsw.samples.services.ServicesIdeas;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "publicoBean")
@RequestScoped
public class PublicoBean extends BasePageBean {

	@ManagedProperty(value = "#{param.correo}")
	private String correo;


	private static final long serialVersionUID = 3594009161252782831L;

	@Inject
	private ServicesIdeas services;



	private String input;
	private Usuario usr;
	
	
	 
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Usuario getUsr() throws ServicesException {
		if(usr==null) {
			setUsr(services.consultarUsuario(this.correo));
		}
		return usr;
	}

	public void setUsr(Usuario usr) {
		this.usr = usr;
	}

	

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input.replaceAll("_", " ");;
	}

	public List<Comentario> getComentarios() throws ServicesException {
		System.out.println("Input " + input);
		System.out.println(services.consultarComentariosxIniciativa(input));
		return (List<Comentario>) services.consultarComentariosxIniciativa(input);
	}


	public void registrarComentario(String comen,String correo) throws ServicesException {
		System.out.println(comen+" "+correo + " " + this.input);
		Usuario usr  = services.consultarUsuario(correo);
		Comentario comentario = new Comentario(comen, usr);
		services.agregarComentarioxIniciativa(this.input, comentario);
	}


}
