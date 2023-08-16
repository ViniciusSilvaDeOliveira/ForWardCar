package conexaoBancoDeDados;

import pageObjects.Login;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DatabaseConnectionTest {
    List<String> primeirosNomes = new ArrayList<>();
    List<String> sobrenomes = new ArrayList<>();
    List<String> usuarios = new ArrayList<>();
    List<String> senhas = new ArrayList<>();

    public DatabaseConnectionTest() throws IOException {
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
                primeirosNomes.add(resultSet.getString("primeiro_nome"));
                sobrenomes.add(resultSet.getString("sobrenome"));
                usuarios.add(resultSet.getString("usuario"));
                senhas.add(resultSet.getString("senha"));
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

    public List<String> getPrimeiroNome() {
        return primeirosNomes;
    }

    public List<String> getSobrenome() {
        return sobrenomes;
    }

    public List<String> getUsuario() {
        return usuarios;
    }

    public List<String> getSenha() {
        return senhas;
    }
}
