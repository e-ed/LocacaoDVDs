package locacaodvds.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author eduardo
 */
public class ConnectionFactory {
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mariadb://localhost:3306/locacao_dvds", "root", "");
    }
}
