package edu.school21.repositories;

import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import javax.sql.DataSource;
import java.sql.SQLException;

public class EmbeddedDataSourceTest {
	@BeforeEach
	public void	init() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		DataSource	ds =	builder
							.addScript("src/test/resources/schema.sql")
							.addScript("src/test/resources/data.sql").build();
		try {
			Assert.assertNotNull(ds.getConnection());
		} catch (SQLException exc) { exc.printStackTrace(); }
	}

	@Test
	void start() { ; }
}
