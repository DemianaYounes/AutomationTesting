package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.sound.midi.Track;
import java.util.List;

public class DropdownList {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement CountryDropdown=driver.findElement(By.xpath("//select[@name=\"country\"]"));
        Select CountrySelect=new Select(CountryDropdown);
        CountrySelect.selectByVisibleText("ANGOLA");
        Thread.sleep(2000);
        CountrySelect.selectByValue("ALBANIA");
        Thread.sleep(2000);
        CountrySelect.selectByIndex(8);
        //list option
        List<WebElement> elements=CountrySelect.getOptions();
        for(int i=0;i<elements.size();i++)
        {
            System.out.println(elements.get(i).getText());
        }
    }
}
