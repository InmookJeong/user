package kr.mook.user.database;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Add annotation to load spring when executing Test-code.
 * 
 * @since 2024.04.25
 * @author In-mook, Jeong
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations = {"classpath:framework/spring/context-*.xml"}
)
public class DataSourceTest {
	
	// Dependency Injection
	@Inject
	private DataSource ds;
	
	@Test
	public void testConnection() throws Exception {
		try(Connection con = ds.getConnection()) {
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
