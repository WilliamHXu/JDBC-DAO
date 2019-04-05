package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static final String url = "jdbc:mysql://localhost:3306/jdbcdao?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String username = "root";
    public static final String password = "";

    public static Connection getConnection()
    {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

}
