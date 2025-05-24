package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Hands_on {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        driver.get("https://demo.guru99.com/test/login.html");
        WebElement Email=driver.findElement(By.id("email"));
        if(Email.isDisplayed())
        {
            Email.sendKeys("demiana@gmail.com");
            Thread.sleep(2000);
        }
        WebElement Password=driver.findElement(By.id("passwd"));
        if(Password.isDisplayed())
        {
            Password.sendKeys("1234");
            Thread.sleep(2000);
        }
        Email.clear();
        Email.sendKeys("test@gmail.com");
        Thread.sleep(2000);
        //WebElement SignIn=driver.findElement(By.cssSelector("i[class=\"icon-lock left\"]"));
        WebElement SignIn=driver.findElement(By.id("SubmitLogin"));
        SignIn.submit();
    }
}
