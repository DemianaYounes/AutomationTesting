package FindingElementsTests;

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

public class FindingByElements {
    private WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com");
    }
    @Test
    public void testFindByElements()
    {
        //Get all the links displayed on the page
        List<WebElement> links=driver.findElements(By.tagName("a"));

        //Verify there are 46 links displayed on the page
        //System.out.println(links.size());
        Assert.assertEquals(links.size(),46);

        //Iterate for all links
        for(WebElement link:links)
        {
            System.out.println(link.getAttribute("href"));
        }

    }
    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
