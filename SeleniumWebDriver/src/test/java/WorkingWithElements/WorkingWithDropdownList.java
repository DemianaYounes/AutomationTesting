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

public class WorkingWithDropdownList {
    private WebDriver driver;
    @BeforeTest
    void setup()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
    }
    @Test
    void dropdownListTestCase()
    {
        WebElement OptionList=driver.findElement(By.id("dropdown"));
        OptionList.click();
        Select dropdownList=new Select(OptionList);
        System.out.println(dropdownList.getOptions().size());
        Assert.assertEquals(dropdownList.getOptions().size(),3);
        dropdownList.selectByValue("1");
    }

    @AfterTest
    void quit()
    {
        driver.quit();
    }
}
