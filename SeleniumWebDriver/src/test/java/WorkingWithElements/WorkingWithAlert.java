package WorkingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithAlert {
    private WebDriver driver;
    @BeforeTest
    public void setup()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.navigate().to("https://demo.guru99.com/test/delete_customer.php");
    }
    @Test
    public void AlertTestCase() {
        WebElement customerID=driver.findElement(By.cssSelector("input[type=\"text\"]"));
        WebElement submit=driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        customerID.sendKeys("1234");
        submit.click();
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals(alert.getText(),"Do you really want to delete this Customer?");
        alert.accept();
        Alert alert2=driver.switchTo().alert();
        System.out.println(alert2.getText());
        alert2.accept();
    }

    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
