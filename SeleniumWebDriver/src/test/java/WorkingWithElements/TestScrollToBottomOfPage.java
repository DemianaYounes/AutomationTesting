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

public class TestScrollToBottomOfPage {
    private WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.navigate().to("https://www.amazon.eg/-/en/ref=nav_logo");
    }
    @Test
    public void testScrollWithJs() throws InterruptedException {
        //casting driver to JavascriptExecutor
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,5000)");
        Thread.sleep(3000);

        WebElement amazonLogo=driver.findElement(By.cssSelector("div.nav-logo-base.nav-sprite"));
        Assert.assertTrue(amazonLogo.isDisplayed());

    }
    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
