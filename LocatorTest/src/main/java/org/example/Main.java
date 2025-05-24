package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        driver.get("https://demo.nopcommerce.com/");
        //Register to page by using class name
        WebElement Register=driver.findElement(By.className("ico-register"));
        Register.click();
        //choose gender(female) by using id locator
        driver.findElement(By.id("gender-female")).click();
        //Write first name parameter by using name locator
        driver.findElement(By.name("FirstName")).sendKeys("Demiana");
        //Write last name parameter by using xpath locator
        driver.findElement(By.xpath("//input[@id=\"LastName\"]")).sendKeys("Magdy");
        //Write Email parameter by using css selector
        driver.findElement(By.cssSelector("input[data-val-required=\"Email is required.\"]")).sendKeys("demianayounes7175@gmail.com");
        //Choose log in by using link test or partial link text locator
        //driver.findElement(By.linkText("Log in")).click();
        //Write Company name parameter by using css selector
        driver.findElement(By.cssSelector("input[name=\"Company\"]")).sendKeys("Smart");
        //Write password by using css selector
        driver.findElement(By.cssSelector("input[data-val-regex=\"Password must meet the following rules:  must have at least 6 characters and not greater than 64 characters\"]")).sendKeys("1234");
        //Write confirm password by using xpath locator
        driver.findElement(By.xpath("//input[@data-val-required=\"Password is required.\"]")).sendKeys("1234");

        //wait 3 second then close all tabs
        Thread.sleep(3000);
        driver.quit();
    }
}