package conexaoBancoDeDados;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionTest {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\Users\\tivin\\Desktop\\Estudos\\EstagioBN\\DesafioWeb\\ForWardCar\\src\\test\\resources\\properties\\conexao.properties"));

        String jdbcUrl = prop.getProperty("jdbcUrl");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");

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
