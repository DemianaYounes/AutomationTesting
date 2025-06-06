package WorkingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WorkinWithTextBoxAndButton {
    private WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void LoginScreen()
    {
        //Finding elements by id
        WebElement userName=driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        WebElement Password=driver.findElement(By.id("password"));
        Password.sendKeys("SuperSecretPassword!");
        //Finding elements by class name
        WebElement Login=driver.findElement(By.className("radius"));
        Login.click();

        WebElement successfulNotification=driver.findElement(By.id("flash"));
        System.out.println(successfulNotification.getText());
        Assert.assertTrue(successfulNotification.getText().contains("You logged into a secure area!"));
        WebElement log=driver.findElement(By.linkText("Logout"));
        System.out.println(log.getText());
    }
    @AfterMethod
    public void quit()
    {
        driver.quit();
    }

}
