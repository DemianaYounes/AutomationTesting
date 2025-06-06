package WorkingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestImplicitWait {
    private WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
    }
    @Test
    public void testImplicitWait()
    {

    }

    @AfterTest
    public void quit()
    {
        //driver.quit();
    }
}
