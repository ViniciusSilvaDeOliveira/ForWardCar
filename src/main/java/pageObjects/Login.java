package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private WebDriver driver;
    private By btnGuest = By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[5]/a/span[1]");
    private By btnRegister = By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[5]/ul/li[2]/a");
    private By campoNome = By.xpath("//*[@id=\"registration-form\"]/fieldset/div[1]/input");
    private By campoSobrenome = By.xpath("//*[@id=\"registration-form\"]/fieldset/div[2]/input");
    private By campoUsername = By.xpath("//*[@id=\"registration-form\"]/fieldset/div[3]/input");
    private By campoSenha = By.xpath("//*[@id=\"registration-form\"]/fieldset/div[4]/input");
    private By btnRegisterLogin = By.xpath("//*[@id=\"registration-form\"]/fieldset/div[5]/button");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void clicarBtnGuest(){
        this.driver.findElement(btnGuest).click();
    }

    public void clicarBtnRegister(){
        this.driver.findElement(btnRegister).click();
    }

    public void preencherCampoNome(String nome) {
        this.driver.findElement(campoNome).sendKeys(nome);
    }

    public void preencherCampoSobrenome(String sobrenome) {
        this.driver.findElement(campoSobrenome).sendKeys(sobrenome);
    }

    public void preencherCampoUsuario(String usuario) {
        this.driver.findElement(campoUsername).sendKeys(usuario);
    }

    public void preencherCampoSenha(String senha) {
        this.driver.findElement(campoSenha).sendKeys(senha);
    }

    public void clicarBtnRegisterLogin() {
        this.driver.findElement(btnRegisterLogin).click();
    }
}
