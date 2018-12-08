package edu.eci.pdsw.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.pdsw.persistence.ComentarioDAO;
import edu.eci.pdsw.persistence.IniciativaDAO;
import edu.eci.pdsw.persistence.InteresDAO;
import edu.eci.pdsw.persistence.UsuarioDAO;
import edu.eci.pdsw.persistence.mybatisimpl.MyBATISComentarioDAO;
import edu.eci.pdsw.persistence.mybatisimpl.MyBATISIniciativaDAO;
import edu.eci.pdsw.persistence.mybatisimpl.MyBATISInteresDAO;
import edu.eci.pdsw.persistence.mybatisimpl.MyBATISUsuarioDAO;
import edu.eci.pdsw.samples.services.ServicesIdeas;
import edu.eci.pdsw.samples.services.impl.ServicesIdeasImpl;
import edu.eci.pdsw.samples.services.impl.ServicesIdeasStub;


public class GuiceContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.removeAttribute(Injector.class.getName());
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		Injector injector = Guice.createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {
				 install(JdbcHelper.PostgreSQL);                        
                 setClassPathResource("mybatis-config.xml");         
                 bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
                 bind(IniciativaDAO.class).to(MyBATISIniciativaDAO.class);
                 bind(InteresDAO.class).to(MyBATISInteresDAO.class);
                 bind(ComentarioDAO.class).to(MyBATISComentarioDAO.class);
                 bind(ServicesIdeas.class).to(ServicesIdeasImpl.class);
             }
			}
		);
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.setAttribute(Injector.class.getName(), injector);
	}
