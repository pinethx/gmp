package gmp.util;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

public class JdbcUtilTest {

	@Test
	public void testGetConnection() {
		System.out.printf("%s()%n", "testGetConnection");
		Connection con = JdbcUtil.getConnection();
		System.out.println("con > " + con);
		Assert.assertNotNull(con);
	}

}
