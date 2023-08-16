package runners;

import conexaoBancoDeDados.DatabaseConnectionTest;
import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.Login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StepsTest {
    ChromeDriver navegador = new ChromeDriver();
    Login login = new Login(navegador);
    DatabaseConnectionTest conexao;
    WebDriver driver;

    List<String> primeiroNome;
    List<String> sobrenome;
    List<String> usuario;
    List<String> senha;
    List<Boolean> validacoes = new ArrayList<>();

    public StepsTest() throws IOException {
        conexao = new DatabaseConnectionTest();
    }

    @Dado("que acesso a url {string}")
    public void queAcessoAUrl(String url) throws Exception{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tivin\\Desktop\\Estudos\\EstagioBN\\DesafioWeb\\ForWardCar\\src\\main\\resources\\chromedriver\\chromedriver.exe");//mostrei aonde está
        navegador.get(url); //criei uma nova aba do navegador
    }

    @Quando("clico em Guest")
    public void clicoEmGuest() throws InterruptedException {
        Thread.sleep(3000);
        login.clicarBtnGuest();
    }

    @E("seleciono register")
    public void selecionoRegister() throws InterruptedException {
        Thread.sleep(3000);
        login.clicarBtnRegister();
    }


    @E("prencho as informações de cadastro confirmando o registro")
    public void prenchoAsInformaçõesDeCadastroConfirmandoORegistro() throws InterruptedException {
        primeiroNome = conexao.getPrimeiroNome();
        sobrenome = conexao.getSobrenome();
        usuario = conexao.getUsuario();
        senha = conexao.getSenha();

        for(int i = 0; i < senha.size(); i++){
            login.preencherCampoNome(primeiroNome.get(i));
            login.preencherCampoSobrenome(sobrenome.get(i));
            login.preencherCampoUsuario(usuario.get(i));
            login.preencherCampoSenha(senha.get(i));
            Thread.sleep(3000);
            login.clicarBtnRegisterLogin();
            Thread.sleep(3000);
            validacoes.add(login.textoSignIn());
            login.clicarBtnGuest();
            login.clicarBtnRegister();
        }
    }

    @Entao("sou redirecionado para a tela de login")
    public void souRedirecionadoParaATelaDeLogin(){
        for (int i = 0; i < validacoes.size(); i++){
            assertEquals(validacoes.get(i).toString(), String.valueOf(true));
        }
        navegador.quit();
    }
}
