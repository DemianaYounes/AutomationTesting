import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.fail;

public class TestNGDemo2 {
    private WebDriver driver;
    @BeforeTest (groups = "Regression")
    public void setUp()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.navigate().to("https://demo.guru99.com/test/login.html");
    }
    @Test (priority = 0,groups = {"Regression"})
    public void loginPage()
    {
        driver.findElement(By.id("email")).sendKeys("Demiana");
        driver.findElement(By.id("passwd")).sendKeys("1234");
        driver.findElement(By.id("SubmitLogin")).click();
        //to do test case fail
        //fail("Throw exception");
    }
    @Test (dependsOnMethods = {"loginPage"})
    public void afterLoginPass()
    {
        System.out.println("Login successfully");
    }
    @AfterTest (groups = "Regression")
    public void quit()
    {
        driver.quit();
    }
}
