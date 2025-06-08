package WorkingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestTakeScreenshot {
    private WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.eg/-/en/ref=nav_logo");
    }
    @Test
    public void testTakeScreenshotFailure()
    {
        WebElement searchTxt=driver.findElement(By.id("twotabsearchtextboxxx"));
        searchTxt.sendKeys("Selenium Webdriver Book");
        searchTxt.submit();
        assertTrue(driver.getTitle().contains("Selenium"));
    }
    @Test
    public void testTakeScreenshotPass()
    {
        WebElement searchTxt=driver.findElement(By.id("twotabsearchtextbox"));
        searchTxt.sendKeys("Selenium Webdriver Book");
        searchTxt.submit();
        assertTrue(driver.getTitle().contains("Selenium"));
    }
    @AfterMethod
    public void takeScreenshot(ITestResult result) throws IOException {
        if(ITestResult.FAILURE==result.getStatus())
        {
            //Create reference of take screenshoot
            TakesScreenshot ts=(TakesScreenshot) driver;
            File source=ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source,new File("./Screenshot/"+result.getName()+".png"));
        }
    }
    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
