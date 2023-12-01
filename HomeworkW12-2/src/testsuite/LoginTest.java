package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
//        * Enter “Admin” username
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Admin");
//        * Enter “admin123“ password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
//        * Click on ‘LOGIN’ button
        WebElement loginLink = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        loginLink.click();
//        * Verify the ‘Dashboard’ text is display
        Thread.sleep(5000);
        String actualResult = driver.findElement(By.xpath("//div[@id='app']/div/div/header/div[1]/div[1]/span/h6")).getText();
        System.out.println(actualResult);
        String expectedResult = "Dashboard";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @After
    public void endTest(){
        //closeBrowser();
    }
}

