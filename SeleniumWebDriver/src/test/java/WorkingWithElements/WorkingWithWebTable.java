package WorkingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WorkingWithWebTable {
    private WebDriver driver;
    @BeforeTest
    public void setup()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/tables");
    }
    @Test
    public void webTableTestCase()
    {
        WebElement table1=driver.findElement(By.id("table1"));

        //get all rows
        List<WebElement> rows=table1.findElements(By.tagName("tr"));
        Assert.assertEquals(5,rows.size());

        //get all cells data
        for(WebElement row:rows)
        {
            List<WebElement> cols=row.findElements(By.tagName("td"));
            for(WebElement col:cols)
            {
                System.out.println(col.getText());
            }
            System.out.println();
        }
    }

    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
