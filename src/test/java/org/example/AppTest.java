package org.example;

import constantes.ConstantesUrls;
import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest extends TestCase {
   @Test
   public void testInsercaoTeclas(){
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\tivin\\Desktop\\Estudos\\EstagioBN\\DesafioWeb\\ForWardCar\\src\\main\\resources\\chromedriver\\chromedriver.exe");//mostrei aonde está
       ChromeDriver chromeDriver = new ChromeDriver(); //criei uma nova aba do navegador
       chromeDriver.get(ConstantesUrls.URL);
       chromeDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[5]/a/span[1]")).click();
       chromeDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[5]/ul/li[1]/a")).click();
   }
}
