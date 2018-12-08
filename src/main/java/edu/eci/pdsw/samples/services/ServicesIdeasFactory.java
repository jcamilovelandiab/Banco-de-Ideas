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

import java.util.Optional;

public class ServicesIdeasFactory {

    
    
    private static ServicesIdeasFactory instance = new ServicesIdeasFactory();

    private static Optional<Injector> optInjector;
    
    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
            	install(JdbcHelper.PostgreSQL); 
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
                bind(IniciativaDAO.class).to(MyBATISIniciativaDAO.class);
                bind(InteresDAO.class).to(MyBATISInteresDAO.class);
                bind(ComentarioDAO.class).to(MyBATISComentarioDAO.class);
                bind(ServicesIdeas.class).to(ServicesIdeasImpl.class);
            }
        });
    }
    
    private ServicesIdeasFactory(){
        optInjector = Optional.empty();
    }

    public ServicesIdeas getServicesIdeas(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }
        return optInjector.get().getInstance(ServicesIdeas.class);
    }


    public ServicesIdeas getServicesIdeasTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config.xml"));
        }
        return optInjector.get().getInstance(ServicesIdeas.class);
    }

    public static ServicesIdeasFactory getInstance(){
        return instance;
    }

}
