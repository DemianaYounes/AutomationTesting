package WorkingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class WorkingWithCheckBoxes {
    private WebDriver driver;
    @BeforeMethod
    public void setup()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
    }
    @Test
    public void checkBoxesTestCase()
    {
        WebElement checkbox=driver.findElement(By.xpath("//input[@type=\"checkbox\"][1]"));
        if(!checkbox.isSelected())
        {
            checkbox.click();
        }
    }

    @Test
    public void testIsElementPresent()
    {
        if(isElementPresent(By.xpath("//input[@type=\"checkbox\"][1]")))
        {
            WebElement check1=driver.findElement(By.xpath("//input[@type=\"checkbox\"][1]"));
            if(!check1.isSelected())
            {
                check1.click();
            }
            else {
                Assert.fail("Checkbox1 doesn't exist");
            }
        }
    }

    private boolean isElementPresent(By by)
    {
        try {
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e) {
            return false;
        }
    }
    @AfterMethod
    public void quit()
    {
        driver.quit();
    }
}
