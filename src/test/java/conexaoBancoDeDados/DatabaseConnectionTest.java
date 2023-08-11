package conexaoBancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/bd_for_ward_car";
        String user = "postgres";
        String password = "1234";

        try {
            Class.forName("org.postgresql.Driver");

            //Estabelecer a conexão
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Conexão bem-sucedida!");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
