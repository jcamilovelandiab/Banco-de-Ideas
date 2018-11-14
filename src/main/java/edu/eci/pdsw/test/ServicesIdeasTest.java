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

public class ServicesIdeasTest {

	@Inject
    private SqlSession sqlSession;   
    @Inject
    ServicesIdeas servicesIdeas;
	
    public static SqlSessionFactory getSqlSessionFactory() {
		SqlSessionFactory sqlSessionFactory = null;
		if (sqlSessionFactory == null) {
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream("mybatis-config-h2.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				throw new RuntimeException(e.getCause());
			}
		}
		return sqlSessionFactory;
    }
    
}
