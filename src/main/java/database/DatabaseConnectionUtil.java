package database;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnectionUtil {
	 static String jdbcURL = DatabaseConfig.JDBC_URL;
	 static String jdbcUsername = DatabaseConfig.JDBC_USERNAME;
	 static String jdbcPassword = DatabaseConfig.JDBC_PASSWORD;
	 static String jdbcDriver = DatabaseConfig.JDBC_DRIVER;

    public static Connection getConnection() throws SQLException {
        Connection connection = null;

        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("connected to database.");
        } catch (SQLException e) {
            System.out.println("Error connecting to database.");
            throw e;
        } catch (ClassNotFoundException e) {
            System.out.println("Database driver not found.");
            throw new RuntimeException(e);
        }

        return connection;
    }
}
