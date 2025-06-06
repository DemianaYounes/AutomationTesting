package WorkingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDropActions {
    private WebDriver driver;
    @BeforeTest
    public void setup()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.navigate().to("https://www.globalsqa.com/demo-site/draganddrop/");
    }
    @Test
    public void dragAndDropTestCase() {
        WebElement source=driver.findElement(By.xpath("//li[@class=\"ui-widget-content ui-corner-tr ui-draggable ui-draggable-handle\"][1]"));
        WebElement target=driver.findElement(By.xpath("//div[@class=\"ui-widget-content ui-state-default ui-droppable\"]"));
        Actions builder=new Actions(driver);
        builder.dragAndDrop(source,target).perform();
    }

    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
