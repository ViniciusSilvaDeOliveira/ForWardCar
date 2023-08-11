package runners;

import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Quando;
import org.junit.runner.Runner;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.Login;

public class StepsTest {
    private ChromeDriver navegador = new ChromeDriver();
    Login login = new Login(navegador);

    @Dado("que acesso a url {string}")
    public void que_acesso_a_url(String url) throws Exception{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tivin\\Desktop\\Estudos\\EstagioBN\\DesafioWeb\\ForWardCar\\src\\main\\resources\\chromedriver\\chromedriver.exe");//mostrei aonde está
        navegador.get(url); //criei uma nova aba do navegador
    }

    @Quando("clico em Guest")
    public void clico_em_guest() throws InterruptedException {
        Thread.sleep(6000);
        login.clicarBtnGuest();
    }
}
