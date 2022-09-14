package Testes.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private final String URL = "jdbc:mysql://localhost:3306/agenda";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";
    public Connection conectaBD() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME,PASSWORD);
    }
}
