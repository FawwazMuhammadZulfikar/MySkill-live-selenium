import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends env_target{
    @Test
    public void main(){
        //set driverlocation path
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
        //maximize driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //set url
        driver.get(baseUrl);
        //set duration
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit'][@data-test='login-button']"))
        );
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit'][@data-test='login-button']")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(text(),'Products')]"))
        );
        driver.quit();
    }
    @Test
    public void invalidPassword(){
        //set driverlocation path
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
        //maximize driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //set url
        driver.get(baseUrl);
        //set duration
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit'][@data-test='login-button']"))
        );
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_saqce");
        driver.findElement(By.xpath("//input[@type='submit'][@data-test='login-button']")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(text(),'Products')]"))
        );
        driver.quit();
    }

}
