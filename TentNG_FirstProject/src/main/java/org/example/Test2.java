package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class Test2 {
    WebDriver driver;

    @DataProvider(name="LoginCredentials")
    public static Object [][] LoginCredentials()
    {
        return new Object [][]{
                {"Koko"},
                {"Jojo"},
                {"Madonna"},
                {"Mama"},
                {"Papa"}
        };
    }
    @BeforeTest
    @Parameters ("Browser")
    public void setup(String Browser)
    {
        if(Browser.equalsIgnoreCase("Edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }
        else
        {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com");
    }

    @Test (groups = {"Regression"}, dataProvider="LoginCredentials")
    public void TestCase1(String s)
    {
        System.out.println(s);
    }
    @Test (groups = {"Regression"})
    //@Parameters("UserName2")
    public void TestCase2()
    {
        System.out.println("Welcome2");
    }
    @Test (groups = {"Smoke"})
    public void TestCase3()
    {
        System.out.println("Welcome3");
    }

    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
