package WorkingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClickWithAction {
    private WebDriver driver;
    @BeforeTest
    public void setup()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.navigate().to("https://codepen.io/blink172/pen/vERyxK");
    }
    @Test
    public void doubleClickTest() {
        WebElement message=driver.findElement(By.id("click"));
        Actions builder=new Actions(driver);
        builder.doubleClick(message).perform();
    }

    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
