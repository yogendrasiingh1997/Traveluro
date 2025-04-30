package Day_46;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

//@Listeners(MyTestListeners.class)
public class listeners {
    WebDriver driver;

    @BeforeClass
    void setup()
    {
        driver= new ChromeDriver();
        driver.get("https://www.traveluro.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test (priority = 2, dependsOnMethods = {"logo"})
    void url()
    {
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.traveluro.comm/");
    }


    @Test (priority = 1)
    void logo()
    {
        boolean logo= driver.findElement(By.xpath("//span[@class='logo sprites4 bg-logo']")).isDisplayed();
        Assert.assertEquals(logo,true);
    }

    @Test (priority = 3, dependsOnMethods = {"url"})
    void title()
    {
        Assert.assertEquals(driver.getTitle(), "Hotel booking | Traveluro.com");
    }


    @AfterClass
    void teardown()
    {
        driver.quit();
    }

    public WebDriver getDriver()
    {
       return  driver;
    }
}
