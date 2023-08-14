package conexaoBancoDeDados;

import pageObjects.Login;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnectionTest {
    String primeiroNome;
    String sobrenome;
    String usuario;
    String senha;

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
                primeiroNome = resultSet.getString("primeiro_nome");
                sobrenome = resultSet.getString("sobrenome");
                usuario = resultSet.getString("usuario");
                senha = resultSet.getString("senha");
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

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
