package WorkingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class TestImplicitWait {
    private WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.navigate().to("https://testpages.eviltester.com/styled/basic-ajax-test.html");
    }
    @Test
    public void testImplicitWait()
    {
        //Set the implicitly wait time to 2- seconds
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement codeIn=driver.findElement(By.xpath("//input[@value=\"Code In It\"]"));
        codeIn.click();
        assertTrue(codeIn.getText().contains("You submitted a form"));
    }

    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
