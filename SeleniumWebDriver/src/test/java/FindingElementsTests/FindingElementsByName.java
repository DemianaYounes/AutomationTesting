package FindingElementsTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class FindingElementsByName {
    private WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }
    @Test(priority = 0)
    public void loginPageValid()
    {
        try {
            //Finding elements by Name
            WebElement userName=driver.findElement(By.name("username"));
            userName.sendKeys("tomsmith");
            WebElement Password=driver.findElement(By.name("password"));
            Password.sendKeys("SuperSecretPassword!");
            //Finding elements by class Name
            WebElement Login=driver.findElement(By.className("radius"));
            Login.click();
        } catch (NoSuchElementException e) {
            System.out.println("The Elements is not found please use another attribute");
        }
    }
    @Test (priority = 1)
    public void loginPageInValid()
    {
        //Finding elements by Name
        WebElement userName=driver.findElement(By.name("username"));
        userName.sendKeys("Demiana");
        WebElement Password=driver.findElement(By.name("password"));
        Password.sendKeys("1234!");
        //Finding elements by class Name
        WebElement Login=driver.findElement(By.className("radius"));
        Login.click();
    }
    @AfterMethod
    public void quit()
    {
        driver.quit();
    }
}
