package edu.eci.pdsw.samples.services.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.pdsw.entities.*;
import edu.eci.pdsw.persistence.mybatisimpl.mappers.IniciativaMapper;
import edu.eci.pdsw.persistence.mybatisimpl.mappers.UsuarioMapper;
import edu.eci.pdsw.samples.services.*;

public class MyBatisExample {
	
	
	public static SqlSessionFactory getSqlSessionFactory() {
		SqlSessionFactory sqlSessionFactory = null;
		if (sqlSessionFactory == null) {
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream("mybatis-config.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				throw new RuntimeException(e.getCause());
			}
		}
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
		
		  SqlSessionFactory sessionfact = getSqlSessionFactory();
	      SqlSession sqlss = sessionfact.openSession();
	      
	      ServicesIdeasFactory servicesFactory = ServicesIdeasFactory.getInstance();
	      ServicesIdeas ideasServices = servicesFactory.getIdeasServices();
	      UsuarioMapper usrMapper =  sqlss.getMapper(UsuarioMapper.class);
	      /*
	      IniciativaMapper iniMapper =  sqlss.getMapper(IniciativaMapper.class);
	      Area area = new Area("AreaPrueba", "descripcionPrueba");
	      area.setId(2);
	      Usuario usr = new Usuario("John Ibanez","john.ibanez@mail.escuelaing.edu.co", area,Rol.PUBLICO);
	      Iniciativa ini = new Iniciativa("iniciativa prueba", "prueba de insercion",Estado.EN_ESPERA, usr);	      
	      System.out.println(usrMapper.consultarUsuario("john.ibanez@mail.escuelaing.edu.co"));*/
	      //usrMapper.crearUsuario(usr); bien
	      //usrMapper.asignarPerfil("john.ibanez@mail.escuelaing.edu.co",Rol.PMO_ODI); correr de nuevo base
	      //usrMapper.consultarUsuario("john.ibanez@mail.escuelaing.edu.co"); error en mappers
	      //usrMapper.consultarUsuarios();  error en mappers
	      //iniMapper.crearIniciativa(ini);  bien
	      //iniMapper.agregarPalabraClave(6,"pruebas");iniMapper.agregarPalabraClave(6,"mappers"); bien confirmar en la base
	      //iniMapper.modificarEstado(6, Estado.EN_REVISION);  bien confirmar en la base
	      //iniMapper.consultarIniciativasxClaves("pruebas"); no implementado

	      try {
	    	 /*
	      System.out.println(usrMapper.consultarUsuario("john.ibanez@mail.escuelaing.edu.co"));
	       try {
	    	  Area area = new Area("AreaTest", "descripcionTest");
	    	  area.setId(1);
	    	  Usuario usuario = new Usuario("Yohanna Toro","yohanna.toro@mail.escuelaing.edu.co",area,Rol.ADMINISTRADOR);
	    	  area.setId(2);
	    	  Usuario usuario2 = new Usuario("John Ibanez","john.ibanez@mail.escuelaing.edu.co",area,Rol.PROPONENTE);
	    	  //ideasServices.crearUsuario(usuario);
	    	  //ideasServices.crearUsuario(usuario2);
	    	  System.out.println(ideasServices.consultarUsuario("yohanna.toro@mail.escuelaing.edu.co"));
	    	  System.out.println(ideasServices.consultarUsuarios());
	    	  ideasServices.asignarPerfil("yohanna.toro@mail.escuelaing.edu.co",Rol.PMO_ODI);
	    	  System.out.println(ideasServices.consultarUsuario("yohanna.toro@mail.escuelaing.edu.co"));
	    	  ArrayList<String> palabrasClave = new ArrayList();
	    	  palabrasClave.add("biblioteca"); palabrasClave.add("Acabar el E");
	    	  palabrasClave.add("plataformas a la primera");
	    	  Iniciativa ini=new Iniciativa("Hacer el bloque XD","Joder tio, en que pensáis ?",usuario2, palabrasClave);
	    	  //ideasServices.crearIniciativa(ini);
	    	  //ideasServices.modificarEstado("Hacer una biblioteca", Estado.DESECHADO);*/
	      	  
	    	  
	    	  
	    	  // ----------------------  CREANDO Y PROBANDO INICIATIVAS -----------------------
	    	  Usuario usrJohn = ideasServices.consultarUsuario("john.ibanez@mail.escuelaing.edu.co");
	    	  Usuario usrVelan = ideasServices.consultarUsuario("juan.velandia-b@mail.escuelaing.edu.co");
	    	  Usuario usrAlejo = ideasServices.consultarUsuario("jose.naranjo@mail.escuelaing.edu.co");
	    	  Usuario usrYowis = ideasServices.consultarUsuario("yohanna.toro@mail.escuelaing.edu.co");
	    	  Collection<Usuario> usuarios = ideasServices.consultarUsuarios();
	    	  for (Usuario usr : usuarios) {
	    		  System.out.println(usr);
	    	  }
	    	  assert(usrJohn!=null); assert(usrVelan!=null); assert(usrAlejo!=null); assert(usrYowis!=null);
	    	  
	    	  
	    	  
	    	  /*
	    	  ArrayList<String> palabrasClave = new ArrayList();
	    	  palabrasClave.add("biblioteca"); palabrasClave.add("prueba"); palabrasClave.add("plataformas a la primera");
	    	  palabrasClave.add("amo a mi escuela");
	    	  
	    	  Iniciativa ini0=new Iniciativa("ESTO ES UNA PRUEBITA","ESTO ES UNA PRUEBITA DONT WORRY",usrJohn, palabrasClave);
	    	  ideasServices.crearIniciativa(ini0);
	    	  System.out.println(ideasServices.consultarIniciativa("ESTO ES UNA PRUEBITA"));
	    	  
	    	  palabrasClave.add("restaurante");
	    	  Iniciativa ini1 = new Iniciativa("Hacer un centro de comidas","no hay muchos restaurantes",usrJohn, palabrasClave);
	    	  ideasServices.crearIniciativa(ini1);
	    	  System.out.println(ideasServices.consultarIniciativa("Hacer un centro de comidas"));
	    	  
	    	  ArrayList<String> palabrasClave2 = new ArrayList();
	    	  palabrasClave2.add("haCer reStaurantes");
	    	  palabrasClave2.add("mejOrar la cCmida");
	    	  
	    	  Iniciativa ini2 = new Iniciativa("ConstrUir Un MeJoR resTaurante","Por favor a mEjorar CHIcos", usrYowis, palabrasClave2);
	    	  ideasServices.crearIniciativa(ini2);
	    	  System.out.println(ideasServices.consultarIniciativa("ConstrUir Un MeJoR resTaurante"));
	    	  
	    	  Iniciativa ini3 = new Iniciativa("Bajar el precio a los almuerzos","Por favor a mEjorar CHIcos", usrVelan, palabrasClave2);
	    	  ideasServices.crearIniciativa(ini3);
	    	  System.out.println(ideasServices.consultarIniciativa("Bajar el precio a los almuerzOs"));
	    	  
	    	  ArrayList<String> palabrasClave3 = new ArrayList();
	    	  palabrasClave3.add("infraestructura"); palabrasClave3.add("no hay espacio");
	    	  palabrasClave3.add("amo a mi escuela");
	
	    	  
	    	  Iniciativa ini4 = new Iniciativa("Construir un nuevo edificio","Por favor a mEjorar CHIcos", usrVelan, palabrasClave3);
	    	  ideasServices.crearIniciativa(ini4);
	    	  System.out.println(ideasServices.consultarIniciativa("Bajar el precio a los almuerzOs"));
	    	  
	    	  
	    	  ArrayList<String> palabrasClave4 = new ArrayList();
	    	  palabrasClave4.add("infraestructura"); palabrasClave4.add("no hay biblioteca comoda");
	    	  palabrasClave4.add("amo a mi escuela");
	    	  
	    	  Iniciativa ini5 = new Iniciativa("Hacer una biblioteca","no tenemos una biblioteca comoda", usrVelan, palabrasClave4);
	    	  ideasServices.crearIniciativa(ini5);
	    	  System.out.println(ideasServices.consultarIniciativa("Hacer una bibLioteca"));
	    	  
	    	  System.out.println("\nTODAS LAS INICIATIVAS");
	    	  Collection<Iniciativa> inisQuery = ideasServices.consultarIniciativas();
	    	  for (Iniciativa ini : inisQuery) {
	    		  System.out.println(ini);
	    	  }
	    	  
	    	  // -----------------------------------------------------------------------------
	    	  */
	    	  
	    	  
	    	  
	    	  /*
	    	  Collection<Usuario> usuarios = ideasServices.consultarUsuarios();
	    	  System.out.println("------ USUARIOS ------");
	    	  for (Usuario usuario : usuarios) {
	    		  System.out.println(usuario);
	    	  }
	    	  System.out.println("\nCONSULTANDO A YOWIS");
	    	  Usuario usrYowis = ideasServices.consultarUsuario("yohanna.toro@mail.escuelaing.edu.co");
	    	  System.out.println(usrYowis);
	    	  System.out.println("\nCAMBIO ROL A YOWIS POR ADMINISTRADOR");
	    	  ideasServices.asignarPerfil("yohanna.toro@mail.escuelaing.edu.co", Rol.ADMINISTRADOR);
	    	  System.out.println(ideasServices.consultarUsuario("yohanna.toro@mail.escuelaing.edu.co"));
	    	  */
	    	  
	    	  
	    	  /*
	    	  Iniciativa iniciativaPrueba = ideasServices.consultarIniciativa("Hacer el bloque tu");
	    	  System.out.println("\nINICIATIVA -> "+iniciativaPrueba);
	    	  System.out.println("\nINICIATIVAS POR PALABRAS CLAVE");
	    	  Collection<Iniciativa> inisQuery = ideasServices.consultarIniciativasxClaves(palabrasClave);
	    	  for (Iniciativa ini : inisQuery) {
	    		  System.out.println(ini);
	    	  }*/
	    	  
	    	  
	    	  
	    	  //System.out.println("\nNUEVA INICIATIVA");
	    	  
	    	  
	    	  /*
	    	  Collection<Iniciativa> iniciativas =  ideasServices.consultarIniciativasxProponente("john.ibanez@mail.escuelaing.edu.co");
	    	  for (Iniciativa ini : iniciativas) {
	    		  System.out.println(ini.getNombre() + "-> " + ini.getProponente());
	    	  }*/
                  //Area area = new Area("AreaTest", "descripcionTest");
	    	  //area.setId(1);
                  //Usuario usuario = new Usuario("Alejandor Guzman","jose.naranjo@mail.escuelaing.edu.co",area,Rol.PUBLICO);
	    	  //Usuario usuario2 = new Usuario("Camilo Velandia","juan.velandia-b@mail.escuelaing.edu.co",area,Rol.PMO_ODI);
                  //ideasServices.crearUsuario(usuario);
                  //ideasServices.crearUsuario(usuario2);
	    	  
	    	  
	    	  
	    	  /*
	    	  // -------------------------- PROBANDO  VOTOS --------------------------
	    	  System.out.println("PROBANDO VOTOS");
	    	  System.out.println(ideasServices.consultarIniciativa("Hacer una biblioteca"));
	    	  //ideasServices.agregarVotanteAIniciativa("john.ibanez@mail.escuelaing.edu.co","Hacer una biblioteca");
	    	  //ideasServices.agregarVotanteAIniciativa("yohanna.toro@mail.escuelaing.edu.co","Hacer una biblioteca");
	    	  ideasServices.agregarVotanteAIniciativa("juan.velandia-b@mail.escuelaing.edu.co","hacer un centro de comidas");
	    	  ideasServices.agregarVotanteAIniciativa("john.ibanez@mail.escuelaing.edu.co","hacer un centro de comidas");
	    	  ideasServices.agregarVotanteAIniciativa("jose.naranjo@mail.escuelaing.edu.co","hacer un centro de comidas");
	    	  ideasServices.agregarVotanteAIniciativa("jose.naranjo@mail.escuelaing.edu.co", "bajar el precio a los almuerzos");
	    	  ideasServices.agregarVotanteAIniciativa("yohanna.toro@mail.escuelaing.edu.co","construir un nuevo edificio");
	    	  ideasServices.agregarVotanteAIniciativa("juan.velandia-b@mail.escuelaing.edu.co","esto es una pruebita");
	    	  
	    	  
	    	  // PROBANDO CONSULTAR VOTANTES X INICIATIVA
	    	  Collection<Usuario> votantes = ideasServices.consultarVotantesxIniciativa("hacer un centro de comidas");
	    	  for (Usuario vot : votantes) {
	    		  System.out.println(vot);
	    	  }
	    	  //ideasServices.eliminarVotanteAIniciativa("john.ibanez@mail.escuelaing.edu.co", "hacer un centro de comidas");
	    	  System.out.println(ideasServices.consultarCantidadVotos("hacer un centro de comidas"));
	    	  
	    	  
	    	  // ------------------------------------------------------------------------------
	    	  */
	    	  
	    	  /*
	    	  Collection<Iniciativa> iniciativas = ideasServices.consultarIniciativas();
	    	  System.out.println("\nCONSULTAR INICIATIVAS\n");
	    	  for (Iniciativa ini : iniciativas) {
	    		  System.out.println(ini);
	    	  }*/
	    	  
	    	  /*
	    	  // -------------------------- PROBANDO  COMENTARIOS --------------------------
	    	  System.out.println("\nCONSULTAR COMENTARIOS\n");
	    	  Collection<Comentario> comentarios = ideasServices.consultarComentariosxIniciativa("construir un mejor restaurante");
	    	  System.out.println("COMENTARIOS DE RESTAURANTE");
	    	  for (Comentario com : comentarios) {
	    		  System.out.println(com);
	    	  }
	    	  Comentario comentario = new Comentario("Deberiamos tener una biblioteca de mejor calidad", usrAlejo);
	    	  //ideasServices.agregarComentarioxIniciativa("hacer una biblioteca", comentario);
	    	  
	    	  Collection<Comentario> comentariosQ = ideasServices.consultarComentariosxIniciativa("hacer una biblioteca");
	    	  System.out.println("COMENTARIOS DE BIBLIOTECA");
	    	  for (Comentario com : comentariosQ) {
	    		  System.out.println(com);
	    	  }*/
	    	  // -------------------------- PROBANDO INTERESES --------------------------
	    	  /*Interes interes = new Interes("Interesada en aportar con mis ideas","estoy interesada, la propuesta es buena",true,usrYowis);
	    	  //ideasServices.usuarioMuestraInteresxIniciativa("construir un nuevo edificio", interes);
	    	  
	    	  System.out.println("CONSULTAR INTERESES");
	    	  Collection<Interes> interesesBiblioteca = ideasServices.consultarInteresesxIniciativa("hacer una biblioteca");
	    	  Collection<Interes> interesesVelan = ideasServices.consultarInteresesxUsuario(usrVelan.getCorreo());
	    	  System.out.println("INTERESES DEL VELAN");
	    	  for (Interes inter : interesesVelan) {
	    		  System.out.println(inter);
	    	  }
	    	  System.out.println("INTERESES DE LA BIBLIOTECA");
	    	  for (Interes inter : interesesBiblioteca) {
	    		  System.out.println(inter);
	    	  }*/
	    	  
	    	  // ---------------------------- PROBANDO INICIATIVAS RELACIONADAS DADA UNA INICIATIVA ----------------------------
	    	  /*
	    	  System.out.println("\nConsultar iniciativas relacionadas");
	    	  Iniciativa iniHacerBiblioteca = ideasServices.consultarIniciativa("hacer una biblioteca");
	    	  System.out.println(iniHacerBiblioteca+"\n");
	    	  assert(iniHacerBiblioteca!=null);
	    	  Collection<Iniciativa> iniciativasRelacionadas = ideasServices.consultarIniciativasRelacionadas("hacer una biblioteca");
	    	  for (Iniciativa iniRelacionada : iniciativasRelacionadas) {
	    		  System.out.println(iniRelacionada);
	    	  }*/
	    	  
	    	  // ----------------------------- PROBANDO MODIFICAR LA DESCRIPCION DE LAS INICIATIVAS EN ESPERA -----------------
	    	  /*
	    	  Iniciativa iniHacerBiblioteca = ideasServices.consultarIniciativa("hacer una biblioteca");
	    	  ideasServices.modificarIniciativaxEstado("hacer una biblioteca", "No tenemos una biblioteca decente y mas grande");
	    	  Iniciativa iniHacerBibliotecaMod = ideasServices.consultarIniciativa("hacer una biblioteca");
	    	  assert(iniHacerBiblioteca!=iniHacerBibliotecaMod);
	    	  */
	    	  //ideasServices.modificarIniciativaxEstado("esto es una pruebita", "Es una nueva descripcion");
	    	  
	      } catch (ServicesException e){
			  System.out.println(e.getMessage());
	      }
	      sqlss.commit();
	      sqlss.close();
		
		
		/*
		// PROBANDO CON SERVICES IDEAS STUB
		ServicesIdeasFactory servicesFactory = ServicesIdeasFactory.getInstance();
	    ServicesIdeas ideasServices = servicesFactory.getIdeasServices();
	    Area area = new Area("AreaPrueba", "descripcionPrueba");
	    Usuario usr = new Usuario("John Ibanez","john.ibanez@mail.escuelaing.edu.co", area, Rol.PUBLICO);
	    try {
			ideasServices.crearUsuario(usr);
			System.out.println("INGRESE EL USUARIO");
			Usuario usrQuery = ideasServices.consultarUsuario("john.ibanez@mail.escuelaing.edu.co");
			if(usrQuery != null) {
				System.out.println(usrQuery.getNombre()+ " SI ESTA EN LA BASE DE DATOS (: ");
			}
		} catch (ServicesException e) {
			System.err.println(e.getMessage());
		}
	    */
	}
}
