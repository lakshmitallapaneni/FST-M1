import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import static org.testng.AssertJUnit.assertTrue;

public class Activity6_Activities {
    WebDriver driver;
    @BeforeClass
    public void openBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }
    @Test(priority = 0)
    public void loginValidation() {
        driver.findElement(By.xpath("//*[@id=\"user_name\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"username_password\"]")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//*[@id=\"bigbutton\"]")).click();
        assertTrue(driver.findElement(By.id("recentlyViewedSidebar")).isDisplayed());
    }
    @Test(priority = 1)
    public void activityMenuValidation() throws InterruptedException {
//        Thread.sleep(1000);
        assertTrue( driver.findElement(By.xpath("(//*[@class='dropdown-toggle grouptab'])[3]")).isDisplayed());
        Thread.sleep(5000);
    }
    @AfterTest
    public void closedriver() {
        driver.close();
    }
}
