package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    //Declaring BaseURL
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.xpath("//li[@class = 'header__nav-item header__nav-sign-in']")).click();
        String expected = "Welcome Back!";
        String actual = driver.findElement(By.xpath("//h2[@class = 'page__heading']")).getText();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void verifyTheErrorMessage(){
        driver.findElement(By.xpath("//li[@class = 'header__nav-item header__nav-sign-in']")).click();
        driver.findElement(By.id("user[email]")).sendKeys("prime123@gmail.com");
        driver.findElement(By.id("user[password]")).sendKeys("Prime@123");
        driver.findElement(By.xpath("//button[@class = 'button button-primary g-recaptcha']")).click();
        String expected = "Invalid email or password.";
        String actual = driver.findElement(By.xpath("//li[@class = 'form-error__list-item']")).getText();
        Assert.assertEquals(expected,actual);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
