package WorkingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.testng.Assert.assertTrue;

public class TestFluentWait {
    private WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.navigate().to("https://www.google.com");
    }
    @Test
    public void testFluentWait()
    {
        WebElement queryTxt=driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
        queryTxt.sendKeys("selenium webdriver");
        queryTxt.submit();

        Wait<WebDriver> Fwait=new FluentWait<>(driver)
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(2,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement message=Fwait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver d)
            {
                return d.findElement(By.id("page4"));
            }
        });

    }

    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
