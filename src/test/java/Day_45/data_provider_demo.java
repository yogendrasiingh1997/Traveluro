package Day_45;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class data_provider_demo {

    WebDriver driver;
    Actions act;


    @BeforeClass
    void setup()
    {
        driver= new ChromeDriver();
        driver.get("https://www.traveluro.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test (dataProvider = "dp")
    void login(String email, String password) throws InterruptedException

    {
        WebElement login_btn=driver.findElement(By.xpath("//a[@class='clickable'][normalize-space()='Login']"));
        WebElement emailInput=driver.findElement(By.xpath("//div[@id='myModalNorm']//input[@id='email']"));
        WebElement passwordInput=driver.findElement(By.xpath("//div[@id='myModalNorm']//input[@id='password']"));
        WebElement submit=driver.findElement(By.xpath("//div[@id='myModalNorm']//button[@type='submit'][normalize-space()='Login']"));

        //login_btn.click();
        login_btn.click();
        Thread.sleep(3000);

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submit.click();

        if (!driver.findElements(By.xpath("//a[@id='sm-15236008200698604-3']")).isEmpty())
        {
            System.out.println("Login successful");

            WebElement hower = driver.findElement(By.xpath("//a[@id='sm-15236008200698604-3']"));
            act = new Actions(driver);
            act.moveToElement(hower).perform();

            WebElement logout_btn = driver.findElement(By.xpath("//a[@class='logout-menu']"));
            logout_btn.click();

        }
        else
        {
            System.out.println("Login failed, refreshing the page...");
            driver.navigate().refresh();
            Thread.sleep(2000);
        }

    }


    @AfterClass
    void finalstep()
    {
        driver.quit();
    }


    @DataProvider(name="dp", indices = {0,1,2,3,4})
    Object [][] logindata()
    {
            Object data [][]=
                    {
                            {"abc@gmail.com", "1234"},
                            {"yogendra@gmail.com", "Abcd@1234"},
                            {"parth@splittytravel.com", "1234"},
                            {"parth@splittytravel.com", "Abcd@1234"},
                            {"yogendra@@gmail.com", "Abcd@1234"},
                    };

        return data;
    }

}
