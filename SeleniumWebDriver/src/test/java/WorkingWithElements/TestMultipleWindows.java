package WorkingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestMultipleWindows {
    private WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
    }
    @Test
    public void testWindowHandle()
    {
        //store window handle in parent window
        String parentWindowID=driver.getWindowHandle();
        driver.findElement(By.id("newWindowBtn")).click();
        for(String windowId: driver.getWindowHandles())
        {
            String title=driver.switchTo().window(windowId).getTitle();
            if(title.equals("Basic Controls"))
            {
                assertEquals(driver.getTitle(), "Basic Controls");
                System.out.println(driver.getTitle());
                //Write any code to handle elements in visit us page
                driver.close();
                break;
            }
        }
        driver.switchTo().window(parentWindowID);
    }
    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
