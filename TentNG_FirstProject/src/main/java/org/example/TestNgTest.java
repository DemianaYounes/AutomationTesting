package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

public class TestNgTest {
    WebDriver driver;

    @BeforeClass
    public void setup()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com");
    }
    @Test (priority = 1)
    public void TestCase1()
    {
        System.out.println("Helllllllllllo");
    }
    @Test (priority = 0)
    public void TestCase2()
    {
        System.out.println("Damdoma");
    }
    @Test (priority = 2)
    public void TestCase3()
    {
        System.out.println("Jojo");
    }

    @AfterClass
    public void quit()
    {
        driver.quit();
    }
}
