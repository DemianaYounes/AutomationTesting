package WorkingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestJavaScriptCalls {
    private WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.navigate().to("https://www.google.com");
    }
    @Test
    public void testJavaScript()
    {
        //casting driver to JavascriptExecutor
        JavascriptExecutor js=(JavascriptExecutor) driver;
        //casting executeScript to string
        String title= js.executeScript("return document.title").toString();
        assertEquals(title,"Google");
        System.out.println(title);

        //casting executeScript to long
        long links= (long) js.executeScript("var links=document.getElementsByTagName('A'); return links.length;");
        System.out.println(links);
        Assert.assertEquals(links,17);
    }
    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
