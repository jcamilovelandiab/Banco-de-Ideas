package edu.eci.pdsw.samples.services.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

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
	    	  Iniciativa ini=new Iniciativa("Hacer una biblioteca","Nuestra biblioteca es muy chiquita",
	    			  usuario2);
	    	  
	    	  
	      } catch (ServicesException e) {
			
			System.out.println(e.getMessage());
	      }
	      sqlss.commit();
	      sqlss.close();
		
		
		
		// PROBANDO CON SERVICES IDEAS STUB
		/*ServicesIdeasFactory servicesFactory = ServicesIdeasFactory.getInstance();
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
		}*/
	    
	}
}
