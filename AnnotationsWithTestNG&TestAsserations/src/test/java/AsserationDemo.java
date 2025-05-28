import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AsserationDemo {
    public WebDriver driver;
    @BeforeTest
    public void SetUp()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.navigate().to("https://demo.guru99.com");
    }
    @Test
    public void TestCase1()
    {
        String title=driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Guru99 Bank Home Page");
    }
    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
