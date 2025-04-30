package Day_45;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class param_test {

    WebDriver driver;

    @Parameters({"browser", "url"})
    @BeforeClass
    void setup(String br, String url)
    {
        switch (br)
        {
            case "chrome"  : driver= new ChromeDriver(); break;
            case "edge"    : driver=new EdgeDriver(); break;
            case "firefox" : driver= new FirefoxDriver(); break;
            default: System.out.println("invalid browser"); return;
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    void logo()
    {
        boolean logo= driver.findElement(By.xpath("//span[@class='logo sprites4 bg-logo']")).isDisplayed();
        Assert.assertEquals(logo,true);
    }

    @Test(priority = 2)
    void title()
    {
        Assert.assertEquals(driver.getTitle(), "Hotel booking | Traveluro.com");
    }

    @Test(priority = 3)
    void url()
    {
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.traveluro.com/");
    }

    @AfterClass
    void teardown()
    {
        driver.quit();
    }
}
