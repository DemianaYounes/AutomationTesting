package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://demo.guru99.com/popup.php");
        String ParentWindow=driver.getWindowHandle();
        WebElement ClickHere=driver.findElement(By.linkText("Click Here"));
        ClickHere.click();
        Set<String> AllWindowHandles=driver.getWindowHandles();
        String newTab="";
        for(String s: AllWindowHandles)
        {
            if(!ParentWindow.equalsIgnoreCase(s))
                newTab=s;
        }
        Thread.sleep(2000);
        driver.switchTo().window(newTab);
        Thread.sleep(2000);
        driver.switchTo().window(ParentWindow);
    }
}
