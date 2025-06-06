package FindingElementsTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class FindingByLinkText {
    private WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }
    @Test
    public void testFindByLinkTest()
    {
        WebElement seleniumLink=driver.findElement(By.linkText("Elemental Selenium"));
        seleniumLink.click();
        System.out.println(seleniumLink.getAttribute("href"));
    }
    @Test
    public void testFindByPartialLinkTest()
    {
        WebElement seleniumPartialLink=driver.findElement(By.partialLinkText("Elemental"));
        seleniumPartialLink.click();
        System.out.println(seleniumPartialLink.getAttribute("href"));
    }
    @AfterMethod
    public void quit()
    {
        driver.quit();
    }
}
