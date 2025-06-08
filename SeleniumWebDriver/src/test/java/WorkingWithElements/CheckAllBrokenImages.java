package WorkingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.online.HttpClient;
import org.apache.commons.io.FileUtils;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.http.HttpResponse;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class CheckAllBrokenImages {
    private WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/broken_images");
    }
    @Test
    public void testBrokenImages()
    {
    }
    public void verifyImageActive(WebElement imageElement) throws IOException {
        CloseableHttpClient client= HttpClientBuilder.create().build();
        HttpGet request=new HttpGet(imageElement.getAttribute("src"));
        CloseableHttpResponse response=client.execute(request);


    }
    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
