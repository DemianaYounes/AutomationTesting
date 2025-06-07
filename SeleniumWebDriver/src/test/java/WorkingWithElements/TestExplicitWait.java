package WorkingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class TestExplicitWait {
    private WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.navigate().to("https://www.google.com");
    }
    @Test
    public void testExplicitWait()
    {
        WebElement queryTxt=driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
        queryTxt.sendKeys("selenium webdriver");
        queryTxt.submit();

        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.titleContains("selenium"));
        assertTrue(driver.getTitle().toLowerCase().startsWith("selenium"));
    }

    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
