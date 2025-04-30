package Day_47;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;
    Actions act;

    @BeforeClass
    void setup()
    {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.traveluro.com/");
        driver.manage().window().maximize();
    }

    @Test
    void login() throws InterruptedException {
        //Page_object_loginpage1 lp= new Page_object_loginpage1(driver);

        Page_object_loginpage2_using_page_factory lp= new Page_object_loginpage2_using_page_factory(driver);
        lp.login_btn();
        lp.setUsername("parth@splittytravel.com");
        lp.setPassword("Abcd@1234");
        lp.submitLoginBtn();

        act= new Actions(driver);
        WebElement text= driver.findElement(By.xpath("//a[@id='sm-15236008200698604-3']"));
        act.moveToElement(text).perform();

        Thread.sleep(3000);

        if(driver.findElement(By.xpath("//a[contains(@class, 'logout-menu')]")).isDisplayed())
        {
            System.out.println("✅ Login successful" );
        }
        else
        {
            System.out.println("❌ Login failed");
        }

        Thread.sleep(2000);

    }


    @AfterClass
    void tearDown()
    {
        driver.quit();
    }


}
