package edu.eci.pdsw.samples.services;


import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;

import edu.eci.pdsw.entities.Area;
import edu.eci.pdsw.entities.Rol;
import edu.eci.pdsw.entities.Usuario;
import edu.eci.pdsw.persistence.*;
import edu.eci.pdsw.persistence.mybatisimpl.*;
import edu.eci.pdsw.samples.services.impl.ServicesIdeasImpl;
import edu.eci.pdsw.samples.services.impl.ServicesIdeasStub;

public class ServicesIdeasFactory {

    
    private static ServicesIdeasFactory instance = new ServicesIdeasFactory();
     
    private static Injector injector;
    private static Injector testingInjector;

    private  ServicesIdeasFactory() {
    	  injector = createInjector(new XMLMyBatisModule() {

              @Override
              protected void initialize() {
                  install(JdbcHelper.PostgreSQL);                        
                  setClassPathResource("mybatis-config.xml");         
                  bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
                  bind(IniciativaDAO.class).to(MyBATISIniciativaDAO.class);
                  bind(ServicesIdeas.class).to(ServicesIdeasImpl.class);
              }

          }
          
    );
  
    	
    	 /*testingInjector = createInjector(new XMLMyBatisModule() {

             @Override
             protected void initialize() {
                 install(JdbcHelper.MySQL);                        
                 setClassPathResource("mybatis-config-h2.xml");                        
                 //bind(ServiciosSuscripciones.class).to(ServiciosSuscripcionesImpl.class);
                 //bind(DaoComentario.class).to(MyBatisDaoComentario.class);
                 
             }

         });*/
    }

    public ServicesIdeas getIdeasServices(){
        return injector.getInstance(ServicesIdeas.class);   
    }
   
    public static ServicesIdeasFactory getInstance(){
        return instance;
    }

}
