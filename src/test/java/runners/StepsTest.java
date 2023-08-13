package runners;

import conexaoBancoDeDados.DatabaseConnectionTest;
import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import org.junit.runner.Runner;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.Login;

public class StepsTest {
    ChromeDriver navegador = new ChromeDriver();
    Login login = new Login(navegador);
    DatabaseConnectionTest conexao = new DatabaseConnectionTest();

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
        //login.preencherCampoNome(conexao);
    }
}
