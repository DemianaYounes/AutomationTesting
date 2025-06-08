package WorkingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestContextMenu {
    private WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");
    }
    @Test
    public void testContextWindow()
    {
        WebElement clickBut=driver.findElement(By.id("hot-spot"));

        Actions builder=new Actions(driver);
        builder.contextClick(clickBut).click().perform();

        //Explicit Wait
        WebDriverWait wait=new WebDriverWait(driver,20);

        //Accept alert
       // Alert alert=driver.switchTo().alert();
        Alert alert=wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());

        assertEquals(alert.getText(),"You selected a context menu");
        alert.dismiss();
    }
    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
