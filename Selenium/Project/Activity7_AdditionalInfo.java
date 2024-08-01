import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class Activity7_AdditionalInfo {
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
    public void additionalInfo() throws InterruptedException {
//        assertTrue( driver.findElement(By.xpath("(//*[@class='dropdown-toggle grouptab'])[3]")).isDisplayed());
        WebElement clickable = driver.findElement(By.xpath("(//*[@class='dropdown-toggle grouptab'])[1]"));
        new Actions(driver)
                .clickAndHold(clickable)
                .perform();
//        WebElement lead = driver.findElement(By.xpath("(//*[@class='dropdown-toggle grouptab'])[1]/ul/li[5]"));
//        new Actions(driver)
//                .clickAndHold(clickable)
//                .perform();
        driver.findElement(By.id("moduleTab_9_Leads")).click();
        driver.findElement(By.id("moduleTab_9_Leads")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@class='suitepicon suitepicon-action-info'])[1]")).click();
//driver.switchTo().window();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("(//*[@class='open ui-dialog-content ui-widget-content'])[1]")).getText());
    }
    @AfterTest
    public void closedriver() {
        driver.close();
    }
}
