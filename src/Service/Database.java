package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    //url of my database
    private static String url = "jdbc:mariadb://localhost:3306/tutorial";

    //credentials
    private static String userId = "root";
    private static String userPassword = "password";

    private Database(){}

    public static Connection getConnection() throws SQLException {
        Connection connection = null; //initiation
        connection = DriverManager.getConnection(url, userId, userPassword);

        return connection;
    }
}
