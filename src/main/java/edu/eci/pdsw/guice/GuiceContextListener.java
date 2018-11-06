package edu.eci.pdsw.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.pdsw.persistence.IniciativaDAO;
import edu.eci.pdsw.persistence.UsuarioDAO;
import edu.eci.pdsw.persistence.mybatisimpl.MyBATISIniciativaDAO;
import edu.eci.pdsw.persistence.mybatisimpl.MyBATISUsuarioDAO;
import edu.eci.pdsw.samples.services.IdeasServices;
import edu.eci.pdsw.samples.services.impl.IdeasServicesImpl;


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
				setEnvironmentId("development");
				setClassPathResource("mybatis-config.xml");
				bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
                
				bind(IdeasServices.class).to(IdeasServicesImpl.class);
                bind(IniciativaDAO.class).to(MyBATISIniciativaDAO.class);

				}
			}
		);
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.setAttribute(Injector.class.getName(), injector);
	}

}