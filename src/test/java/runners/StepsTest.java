package runners;

import conexaoBancoDeDados.DatabaseConnectionTest;
import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.junit.runner.Runner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.Login;

import java.io.IOException;

public class StepsTest {
    ChromeDriver navegador = new ChromeDriver();
    Login login = new Login(navegador);
    DatabaseConnectionTest conexao;
    WebDriver driver;

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
        Thread.sleep(3000);
        login.preencherCampoNome(conexao.getPrimeiroNome());
        login.preencherCampoSobrenome(conexao.getSobrenome());
        login.preencherCampoUsuario(conexao.getUsuario());
        login.preencherCampoSenha(conexao.getSenha());
        Thread.sleep(3000);
        login.clicarBtnRegisterLogin();
    }

    @Entao("sou redirecionado para a tela de login")
    public void souRedirecionadoParaATelaDeLogin() throws Exception{
        Assert.assertTrue(login.textoSignIn());
    }
}
