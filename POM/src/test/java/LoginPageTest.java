import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class LoginPageTest {
    WebDriver driver;
    LoginPage LoginPageObject;

    @BeforeMethod
    public void SetDriver()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void ValidLogin()
    {
        LoginPageObject=new LoginPage(driver);
        LoginPageObject.EnterUserName("tomsmith");
        LoginPageObject.EnterPassword("SuperSecretPassword!");
        LoginPageObject.ClickOnButton();
    }
    @Test
    public void InValidLogin()
    {
        LoginPageObject=new LoginPage(driver);
        LoginPageObject.EnterUserName("Demiana");
        LoginPageObject.EnterPassword("1234!");
        LoginPageObject.ClickOnButton();
    }
    @AfterMethod
    public void Quit()
    {
        driver.quit();
    }

}
