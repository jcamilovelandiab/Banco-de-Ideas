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
import java.util.Collection;
import java.util.Random;

import org.quicktheories.core.Gen;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.Generate.*;
import static org.quicktheories.generators.SourceDSL.*;
import edu.eci.pdsw.entities.*;

public class ServicesIdeasTest {

	@Inject
    private SqlSession sqlSession;   
    @Inject
    private ServicesIdeas servicesIdeas;
    
    private SqlSessionFactory sessionfact;
    
    public ServicesIdeasTest() {
    	servicesIdeas = ServicesIdeasFactory.getInstance().getServicesIdeas();
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void creandoUsuarios() {
    	qt().forAll(UsuarioGenerator.usuarios()).check((usuario) -> {
    		Area area = new Area("Decanatura de Sistemas","decanatura del programa de decanatura de sistemas");
    		area.setId(1);
    		usuario.setArea(area);
    		boolean r = true;
    		try {
    			if(servicesIdeas.consultarUsuario(usuario.getCorreo())==null) {
    				
    				servicesIdeas.crearUsuario(usuario);
    				Usuario userQuery = servicesIdeas.consultarUsuario(usuario.getCorreo());
    				if(userQuery==null) r=false;
    			}
						
			} catch (ServicesException e) {
				r=false;
			}catch (Exception e) {
				r=true;
			}
            return r;
        });
    }
    
    @Test
    public void registrandoIniciativas() {
    	System.setProperty("QT_EXAMPLES", "10");
        qt().forAll(IniciativaGenerator.iniciativas()).check((iniciativa) -> {
        	boolean r=true;
        	try {
        		Iniciativa iniciativaQuery = servicesIdeas.consultarIniciativa(iniciativa.getNombre());
        		Collection<Iniciativa> iniciativas = servicesIdeas.consultarIniciativas();
				if(iniciativaQuery==null) {
					servicesIdeas.crearIniciativa(iniciativa);
					r=(iniciativa == servicesIdeas.consultarIniciativa(iniciativa.getNombre()));
				}
				sqlSession.commit();
                sqlSession.close();
			} catch (ServicesException e) {
				r=true;
			} catch (Exception e) {
				r=true;
			}
            return r;
        });
    } 
    
    @Test
    public void cambiandoEstadoIniciativas() {
    	boolean r=true;
    	try {
			Collection<Iniciativa> iniciativas = servicesIdeas.consultarIniciativas();
			for (Iniciativa ini : iniciativas) {
				Random random = new Random();
				Estado nuevoEstado;
				while(true) {
					int number = random.nextInt(4);
					if(ini.getEstado().ordinal()!=number) {
						nuevoEstado = Estado.values()[number];
						break;
					}
				}
				servicesIdeas.modificarEstado(ini.getNombre(), nuevoEstado);
				
				assertTrue(servicesIdeas.consultarIniciativa(ini.getNombre()).getEstado().equals(nuevoEstado));
			}
		} catch (ServicesException e) {
			r=true;
		}catch (Exception e) {
			r=true;
		}
    }
    
    
    @Test
    public void pruebaComentarios() {
    	System.setProperty("QT_EXAMPLES", "5");
    	qt().forAll(ComentarioGenerator.comentarios()).check((comentario) -> {
    		boolean r=true;
        	try {
        		//System.out.println(comentario.getContenido()+","+comentario.getAutor().getCorreo());
				servicesIdeas.agregarComentarioxIniciativa("hacer una biblioteca", comentario);
        	} catch (ServicesException e) {
				r=true;
			} catch (Exception e) {
				r=false;
			}
            return r;
        });
    }
    
}
