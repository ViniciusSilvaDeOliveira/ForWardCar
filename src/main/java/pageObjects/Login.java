package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private WebDriver driver;
    private By btnGuest = By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[5]/a/span[1]");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void clicarBtnGuest(){
        this.driver.findElement(btnGuest).click();
    }
}
