package conexaoBancoDeDados;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
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
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);//estou realizando a conexão com o banco de dados
            Statement statement = connection.createStatement();//Statement é usado para executar consultas sql
            String sqlQuery = "SELECT * FROM registro";
            ResultSet resultSet = statement.executeQuery(sqlQuery);//a consulta me retorna um obejto ResultSet

            while (resultSet.next()) {
                String primeiroNome = resultSet.getNString("primeiro_nome");
                String sobrenome = resultSet.getString("sobrenome");
                String usuario = resultSet.getString("usuario");
                String senha = resultSet.getString("senha");
            }

            

            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
