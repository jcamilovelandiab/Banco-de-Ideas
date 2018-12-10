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
import java.util.ArrayList;
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
    	System.setProperty("QT_EXAMPLES", "5");
    	qt().forAll(UsuarioGenerator.usuarios()).check((usuario) -> {
    		Area area = new Area("Decanatura de Sistemas","decanatura del programa de Ingenieria de Sistemas");
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
    public void deberiaConsultarCorrectamenteUnUsuario() {
    	System.setProperty("QT_EXAMPLES", "5");
    	qt().forAll(UsuarioGenerator.usuarios()).check((usuario) -> {
    		Area area = new Area("Decanatura de Sistemas","decanatura del programa de Ingenieria de Sistemas");
    		area.setId(1);
    		usuario.setArea(area);
    		boolean r = true;
    		try {
    			servicesIdeas.crearUsuario(usuario);
    			Usuario us = servicesIdeas.consultarUsuario(usuario.getCorreo());
    			if(us != null) {
    				r = usuario.getCorreo().equals(us.getCorreo());
    			}else {
    				r = false;
    			}
						
			} catch (ServicesException e) {
				r = true;
				
			}catch (Exception e) {
				r=true;
			}
            return r;
        });
    }
    
    @Test
    public void deberiaConsultarCorrectamenteLosUsuarios() {
    	System.setProperty("QT_EXAMPLES", "5");
    	qt().forAll(UsuarioGenerator.usuarios(),UsuarioGenerator.usuarios(),UsuarioGenerator.usuarios()).check((usuario1,usuario2,usuario3) -> {
    		Area area = new Area("Decanatura de Sistemas","decanatura del programa de Ingenieria de Sistemas");
    		area.setId(1);
    		usuario1.setArea(area);
    		usuario2.setArea(area);
    		usuario2.setArea(area);
    		boolean r = true;
    		try {
    			servicesIdeas.crearUsuario(usuario1);
    			servicesIdeas.crearUsuario(usuario2);
    			servicesIdeas.crearUsuario(usuario3);
    			ArrayList<Usuario> us = (ArrayList<Usuario>) servicesIdeas.consultarUsuarios();
    			if(us != null) {
    				boolean f1 = false;boolean f2 = false;boolean f3 = false;					
					for(int j = 0; j < us.size(); j++) {
						if(us.get(j).getCorreo().equals(usuario1.getCorreo())) {
							f1 = true;
						}
						if(us.get(j).getCorreo().equals(usuario2.getCorreo())) {
							f2 = true;
						}
						if(us.get(j).getCorreo().equals(usuario3.getCorreo())) {
							f3 = true;
						}
					}
					r=f1 && f2 && f3;
    			}else {
    				r = false;
    			}
						
			} catch (ServicesException e) {
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
    	System.setProperty("QT_EXAMPLES", "5");
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
    
    @Test
    public void DeberiaConsultarUnaIniciativaCorrectamente() {
    	System.setProperty("QT_EXAMPLES", "10");
        qt().forAll(IniciativaGenerator.iniciativas()).check((iniciativa) -> {
        	boolean r=true;
        	try {
        		servicesIdeas.crearIniciativa(iniciativa);
        		Iniciativa iniciativaQuery = servicesIdeas.consultarIniciativa(iniciativa.getNombre());
				if(iniciativaQuery!=null) {
					r=(iniciativa.getNombre().equals(iniciativaQuery.getNombre()));
				}else {
					r = false;
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
    public void DeberiaConsultarLasIniciativasCorrectamente() {
    	System.setProperty("QT_EXAMPLES", "10");
        qt().forAll(IniciativaGenerator.iniciativas(),IniciativaGenerator.iniciativas(),IniciativaGenerator.iniciativas()).check((iniciativa1,iniciativa2,iniciativa3) -> {
        	boolean r=true;
        	try {
        		servicesIdeas.crearIniciativa(iniciativa1);
        		servicesIdeas.crearIniciativa(iniciativa2);
        		servicesIdeas.crearIniciativa(iniciativa3);
        		Collection<Iniciativa>iniciativaQuery = servicesIdeas.consultarIniciativas();
				if(iniciativaQuery!=null) {
					boolean f1 = false;boolean f2 = false;boolean f3 = false;					
					for(int j = 0; j < iniciativaQuery.size(); j++) {
						if(((ArrayList<Iniciativa>) iniciativaQuery).get(j).getNombre().equals(iniciativa1.getNombre())) {
							f1 = true;
						}
						if(((ArrayList<Iniciativa>) iniciativaQuery).get(j).getNombre().equals(iniciativa2.getNombre())) {
							f2 = true;
						}
						if(((ArrayList<Iniciativa>) iniciativaQuery).get(j).getNombre().equals(iniciativa3.getNombre())) {
							f3 = true;
						}
					}
					r=f1 && f2 && f3;
				}else {
					r = false;
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
    public void deberiaAsignarCorrectamenteElPerfilAUnUsuario() {
    	System.setProperty("QT_EXAMPLES", "5");
    	qt().forAll(UsuarioGenerator.usuarios()).check((usuario) -> {
    		Area area = new Area("Decanatura de Sistemas","decanatura del programa de Ingenieria de Sistemas");
    		area.setId(1);
    		usuario.setArea(area);
    		boolean r = true;
    		try {
    			Random random = new Random();
				Rol nuevoRol;
				while(true) {
					int number = random.nextInt(4);
					if(usuario.getTipo().ordinal()!=number) {
						nuevoRol = Rol.values()[number];
						break;
					}
				}
    			servicesIdeas.crearUsuario(usuario);
    			servicesIdeas.asignarPerfil(usuario.getCorreo(),nuevoRol);
    			Usuario us = servicesIdeas.consultarUsuario(usuario.getCorreo());
    			if(us != null) {
    				r = us.getTipo().equals(nuevoRol);
    			}else {
    				r = false;
    			}
						
			} catch (ServicesException e) {
				r=true;
			}catch (Exception e) {
				r=true;
			}
            return r;
        });
    }
    
    @Test
    public void deberiaConsultarCorrectamenteLasIniciativasDeUnUsuario() {
    	System.setProperty("QT_EXAMPLES", "5");
    	qt().forAll(UsuarioGenerator.usuarios(),IniciativaGenerator.iniciativas()).check((usuario,iniciativa) -> {
    		Area area = new Area("Decanatura de Sistemas","decanatura del programa de Ingenieria de Sistemas");
    		area.setId(1);
    		usuario.setArea(area);
    		boolean r = true;
    		boolean flag = false;
    		try {
    			iniciativa.setProponente(usuario);
    			servicesIdeas.crearUsuario(usuario);
    			servicesIdeas.crearIniciativa(iniciativa);
    			ArrayList<Iniciativa> ini = (ArrayList<Iniciativa>) servicesIdeas.consultarIniciativasxProponente(usuario.getCorreo());
    			if(ini != null) {
    				
    				for(int i = 0; i < ini.size() && !flag; i++) {
    					if(ini.get(i).getNombre().equals(iniciativa.getNombre())) {
    						flag = true;
    					}
    				}
    			}else {
    				r = false;
    			}
    			return r && flag;		
			} catch (ServicesException e) {
				r=true;
			}catch (Exception e) {
				r=true;
			}
            return r;
        });
    }
}
