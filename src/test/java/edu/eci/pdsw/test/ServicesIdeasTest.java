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

import edu.eci.pdsw.samples.services.ServicesIdeas;
import edu.eci.pdsw.samples.services.ServicesIdeasFactory;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.quicktheories.core.Gen;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.Generate.*;
import static org.quicktheories.generators.SourceDSL.*;

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
    
    @Test
    public void emptyDB() {
    	System.setProperty("QT_EXAMPLES", "10");
        qt().forAll(longs().from(1).upTo(1000)).check((documento) -> {
            return true;
        });
    }
    
    
}
