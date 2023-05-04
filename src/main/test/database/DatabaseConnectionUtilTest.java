package database;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class DatabaseConnectionUtilTest {

	    @Test
	    public void testGetConnection() throws SQLException {
	        Connection connection = DatabaseConnectionUtil.getConnection();
	        assertNotNull(connection);
	    }
	}


