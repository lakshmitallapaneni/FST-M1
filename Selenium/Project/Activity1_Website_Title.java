import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Activity1_Website_Title {
    WebDriver driver;
    @BeforeClass
    public void openBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void test() {
        System.out.println("title of the page:"+driver.getTitle());
        assertEquals(driver.getTitle(),"SuiteCRM");
    }
    @AfterTest
    public void closedriver() {
        if(driver.getTitle().equals("SuiteCRM"))
        driver.close();
    }
}
