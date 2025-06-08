package WorkingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestFrame {
    private WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
    }
    @Test
    public void testFrameWithIdOrName()
    {
        driver.switchTo().frame("mce_0_ifr");
        WebElement msg=driver.findElement(By.tagName("p"));
        System.out.println(msg.getText());
        Assert.assertEquals(msg.getText(),"Your content goes here.");
        driver.switchTo().defaultContent();
    }
    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
