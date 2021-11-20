/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author JuanPablo
 */
public class LoginTest {

    private WebDriver driver;
    By registerLinkLocator = By.linkText("Sign up");
    By usernameLocator = By.id("sign-username");
    By passwordLocator = By.id("sign-password");
    By btnRegistrar = By.xpath("//button[@onclick='register()']");
    private String Mensaje = "";
    //WebElement alert = driver.findElement(By.linkText("Aceptar"));

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./test/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");

    }

    @Test
    public void TestRegistro() throws InterruptedException {
        driver.findElement(registerLinkLocator).click();
        Thread.sleep(2000);
        driver.findElement(usernameLocator).sendKeys("");
        driver.findElement(passwordLocator).sendKeys("");
        driver.findElement(btnRegistrar).click();
        Thread.sleep(2000);
        Mensaje = driver.switchTo().alert().getText();
        Thread.sleep(2000);
        assertEquals("Please fill out Username and Password.", driver.switchTo().alert().getText());
        //assertEquals("This user already exist.", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        
        //
        //assertEquals("Sign up successful.", driver.switchTo().alert().getText());
        /*}else if(Mensaje == ""){
            System.out.println("Escenario de validación de campos");
        }else{
            System.out.println(Mensaje);
        }
         */
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
