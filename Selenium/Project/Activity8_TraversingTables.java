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

public class Activity8_TraversingTables {
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
    public void traversingTable() throws InterruptedException {
        WebElement clickable = driver.findElement(By.xpath("(//*[@class='dropdown-toggle grouptab'])[1]"));
        new Actions(driver)
                .clickAndHold(clickable)
                .perform();
        driver.findElement(By.id("moduleTab_9_Accounts")).click();
        driver.findElement(By.id("moduleTab_9_Accounts")).click();
        Thread.sleep(2000);
//        for (int i = 1; i <= 10; i += 1) {
//                System.out.println(driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[3]")).getText());
//            }
//        System.out.println(driver.findElement(By.xpath("(//table/tbody/tr[1]/td[3])[1]")).getText());
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[3]/td[3]")).getText());
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[5]/td[3]")).getText());
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[7]/td[3]")).getText());
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[8]/td[3]")).getText());
    }
    @AfterTest
    public void closedriver() {
        driver.close();
    }
}
