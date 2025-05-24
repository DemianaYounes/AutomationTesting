package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    By Username=By.id("username");
    By Password=By.id("password");
    By LoginButton=By.xpath("//button[@type=\"submit\"]");

    //Constructor
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void EnterUserName(String name)
    {
        driver.findElement(Username).sendKeys(name);
    }
    public void EnterPassword(String pass)
    {
        driver.findElement(Password).sendKeys(pass);
    }
    public void ClickOnButton()
    {
        driver.findElement(LoginButton).click();
    }

}
