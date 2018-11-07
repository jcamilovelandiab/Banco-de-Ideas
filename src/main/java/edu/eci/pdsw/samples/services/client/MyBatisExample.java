package edu.eci.pdsw.samples.services.client;

import java.io.IOException;
import java.io.InputStream;

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
	      
	      IdeasServicesFactory servicesFactory = IdeasServicesFactory.getInstance();
	      IdeasServices ideasServices = servicesFactory.getIdeasServices();
	      
	      UsuarioMapper usrMapper =  sqlss.getMapper(UsuarioMapper.class);
	      IniciativaMapper iniMapper =  sqlss.getMapper(IniciativaMapper.class);
	      Area area = new Area("AreaPrueba", "descripcionPrueba");
	      area.setId(2);
	      Usuario usr = new Usuario("John Ibanez","john.ibanez@mail.escuelaing.edu.co", area,Rol.PUBLICO);
	      Iniciativa ini = new Iniciativa("iniciativa prueba", "prueba de insercion",Estado.EN_ESPERA, usr);
	      //usrMapper.crearUsuario(usr); bien
	      //usrMapper.asignarPerfil("john.ibanez@mail.escuelaing.edu.co",Rol.PMO_ODI); correr de nuevo base
	      //usrMapper.consultarUsuario("john.ibanez@mail.escuelaing.edu.co"); error en mappers
	      //usrMapper.consultarUsuarios();  error en mappers
	      //iniMapper.crearIniciativa(ini);  bien
	      //iniMapper.agregarPalabraClave(6,"pruebas");iniMapper.agregarPalabraClave(6,"mappers"); bien confirmar en la base
	      //iniMapper.modificarEstado(6, Estado.EN_REVISION);  bien confirmar en la base
	      //iniMapper.consultarIniciativasxClaves("pruebas"); no implementado
	      
	      try {
			ideasServices.agregarPalabraClave(49,"prueba");
		} catch (ServicesException e) {
			
			System.out.println(e.getMessage());
		}
	      sqlss.commit();
	      sqlss.close();
	}

}
