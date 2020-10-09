package project.port.persistance;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")



public class DataSourceTests {
	  private final Logger logger =LoggerFactory.getLogger(this.getClass());

   @Autowired
   private DataSource dataSource;
   
   @Autowired
   private SqlSessionFactory sqlSessionFactory;
   
   @Test
   public void testConnection() {
	   try(Connection con= dataSource.getConnection();
			  SqlSession session = sqlSessionFactory.openSession(); 
	   ){     logger.info("커넥션 풀 연결="+con);
		       logger.info("mybatis="+session);
	   }catch(Exception e) {
		   fail(e.getMessage());
	   }
   }


}
