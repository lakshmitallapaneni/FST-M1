import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3_copyright_text {
    WebDriver driver;
    @BeforeClass
    public void openBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void test() {
        String copyRightText=  driver.findElement(By.xpath("//*[@id=\"admin_options\"]")).getText();
        System.out.println("copy right text:"+copyRightText);
    }
    @AfterTest
    public void closedriver() {
        driver.close();
    }
}
