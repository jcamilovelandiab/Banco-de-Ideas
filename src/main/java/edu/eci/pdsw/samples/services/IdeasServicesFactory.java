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
import edu.eci.pdsw.samples.services.impl.IdeasServicesImpl;



public class IdeasServicesFactory {

    
    private static IdeasServicesFactory instance = new IdeasServicesFactory();
     
    private static Injector injector;
    private static Injector testingInjector;

    private  IdeasServicesFactory() {
    	  injector = createInjector(new XMLMyBatisModule() {

              @Override
              protected void initialize() {
                  install(JdbcHelper.PostgreSQL);                        
                  setClassPathResource("mybatis-config.xml");         
                  bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
                  bind(IniciativaDAO.class).to(MyBATISIniciativaDAO.class);
                  bind(IdeasServices.class).to(IdeasServicesImpl.class);
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

    public IdeasServices getIdeasServices(){
        return injector.getInstance(IdeasServices.class);   
    }
   
    public static IdeasServicesFactory getInstance(){
        return instance;
    }

}
