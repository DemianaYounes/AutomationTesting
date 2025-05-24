package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AlertAndPopups {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        driver.manage().window().maximize();
        WebElement CustomerId=driver.findElement(By.xpath("//input[@name=\"cusid\"]"));
        WebElement SubmitButton=driver.findElement(By.xpath("//input[@name=\"submit\"]"));
        CustomerId.sendKeys("10");
        SubmitButton.click();
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread.sleep(2000);
        alert.accept();
        Alert alert2=driver.switchTo().alert();
        System.out.println(alert2.getText());
        Thread.sleep(2000);
        alert.accept();
    }
}
