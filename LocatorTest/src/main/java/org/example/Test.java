package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement UserName=driver.findElement(By.id("username"));
        if(UserName.isDisplayed()) //IsDisplayed() function return true or false
        {
            UserName.sendKeys("tomsmith");
        }
        Thread.sleep(3000);
        UserName.clear();
        System.out.println(UserName.isEnabled());
        System.out.println(UserName.getLocation());
        //at checkboxes page
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //to choose checkbox1 or checkbox1 must use xpath method to select index of the array
        WebElement CheckBox=driver.findElement(By.xpath("//input[@type=\"checkbox\"][2]"));
        //isSelected():Return true-->selected , false-->not selected
        System.out.println(CheckBox.isSelected());
        CheckBox.click();
        driver.navigate().back();
    }
}
