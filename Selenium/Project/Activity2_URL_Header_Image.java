import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Activity2_URL_Header_Image {
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
          String url=  driver.findElement(By.xpath("//img[@alt='SuiteCRM']")).getAttribute("src");
          System.out.println("URL of the header image:"+url);
        }
        @AfterTest
        public void closedriver() {
                driver.close();
        }

    }
