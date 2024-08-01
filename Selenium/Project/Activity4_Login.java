import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Activity4_Login {
    WebDriver driver;
    @BeforeClass
    public void openBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void loginValidation() {
     driver.findElement(By.xpath("//*[@id=\"user_name\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"username_password\"]")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//*[@id=\"bigbutton\"]")).click();
        assertTrue(driver.findElement(By.id("recentlyViewedSidebar")).isDisplayed());
       }
    @AfterTest
    public void closedriver() {
        driver.close();
    }
}
