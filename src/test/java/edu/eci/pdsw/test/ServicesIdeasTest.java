package edu.eci.pdsw.test;

import org.apache.ibatis.session.SqlSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;

import edu.eci.pdsw.samples.services.ServicesException;
import edu.eci.pdsw.samples.services.ServicesIdeas;
import edu.eci.pdsw.samples.services.ServicesIdeasFactory;
import edu.eci.pdsw.test.generators.AreaGenerator;
import edu.eci.pdsw.test.generators.ComentarioGenerator;
import edu.eci.pdsw.test.generators.IniciativaGenerator;
import edu.eci.pdsw.test.generators.UsuarioGenerator;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.quicktheories.core.Gen;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.Generate.*;
import static org.quicktheories.generators.SourceDSL.*;
import edu.eci.pdsw.entities.*;

public class ServicesIdeasTest {

	@Inject
    private SqlSession sqlSession;   
    @Inject
    ServicesIdeas servicesIdeas;
    
    public ServicesIdeasTest() {
    	servicesIdeas = ServicesIdeasFactory.getInstance().getServicesIdeasTesting();
    }
    
    @Before
    public void setUp() {
    }
    /*
    @Test
    public void pruebaArea() {
    	System.setProperty("QT_EXAMPLES", "10");
        qt().forAll(AreaGenerator.areas()).check((area) -> {
        	
            return true;
        });
    }
    
    @Test
    public void pruebaUsuarios() {
    	System.setProperty("QT_EXAMPLES", "10");
    	System.out.println("PROBANDO USUARIOS");
    	qt().forAll(UsuarioGenerator.usuarios()).check((usuario) -> {
    		Area area = new Area("Decanatura de Sistemas","decanatura del programa de decanatura de sistemas");
    		area.setId(1);
    		usuario.setArea(area);
    		boolean r = true;
    		try {
    			System.out.println(usuario);
    			if(servicesIdeas.consultarUsuario(usuario.getCorreo())==null) {
    				
    				servicesIdeas.crearUsuario(usuario);
    				Usuario userQuery = servicesIdeas.consultarUsuario(usuario.getCorreo());
    				if(userQuery==null) r=false;
    			}
						
			} catch (ServicesException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				r=false;
			}
            return r;
        });
    }*/
    
    @Test
    public void pruebaIniciativas() {
    	System.setProperty("QT_EXAMPLES", "10");
        qt().forAll(IniciativaGenerator.iniciativas()).check((iniciativa) -> {
        	System.out.println(iniciativa);
            return true;
        });
    }
    
    @Test
    public void pruebaComentarios() {
    	System.setProperty("QT_EXAMPLES", "10");
    	qt().forAll(ComentarioGenerator.comentarios()).check((comentario) -> {
        	System.out.println(comentario);
            return true;
        });
    }
    
}
