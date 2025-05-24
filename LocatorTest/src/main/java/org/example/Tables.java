package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Tables {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://demo.guru99.com/test/write-xpath-table.html");
        WebElement table=driver.findElement(By.xpath("//table[@border=\"l\"]/tbody/tr[1]/td[1]"));
        System.out.println(table.getText());
    }
}
