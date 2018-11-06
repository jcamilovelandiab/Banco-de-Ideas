package edu.eci.pdsw.samples.services.client;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.pdsw.entities.*;
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
	      
	      IdeasServicesFactory servicesFactory = IdeasServicesFactory.getInstance();
	      IdeasServices ideasServices = servicesFactory.getIdeasServices();
	      
	      UsuarioMapper usrMapper =  sqlss.getMapper(UsuarioMapper.class);
	      Area area = new Area("AreaPrueba", "descripcionPrueba");
	      Usuario usr = new Usuario("John Ibanez","john.ibanez@mail.escuelaing.edu.co", area,Rol.PUBLICO);
	      try {
			ideasServices.crearUsuario(usr);
		  } catch (ServicesException e) {
			e.getMessage();
		  }
	     System.out.println("SUPER BIEN");
	    
	      sqlss.commit();
	      sqlss.close();
	}

}
