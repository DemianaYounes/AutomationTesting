package FindingElementsTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.util.List;

public class FindElementInTableByTagName {
    private WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/tables");
    }
    @Test
    public void testFingByTagName()
    {
        WebElement Table=driver.findElement(By.id("table1"));
        List<WebElement> rows=Table.findElements(By.tagName("tr"));

        System.out.println(rows.size());
        System.out.println(rows.get(3).getText());
    }
    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
