import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo {

    public WebDriver driver;
    @BeforeTest
    public void SetUp()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.navigate().to("https://demo.guru99.com");
    }
    @Test (priority = 0)
    public void getCurrentURL()
    {
        System.out.println(driver.getCurrentUrl());
    }
    @Test (priority = 1)
    public void getTitle()
    {
        System.out.println(driver.getTitle());
    }
    @Test (priority = 2 , enabled = false)
    public void getPageSource()
    {
        System.out.println(driver.getPageSource());
    }
    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
