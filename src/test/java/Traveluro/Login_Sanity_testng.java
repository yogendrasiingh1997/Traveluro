package Traveluro;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Login_Sanity_testng {

    WebDriver driver;  //declare in class to use in all method
    JavascriptExecutor js;
    Actions act;

    @Test (priority = 1)
     void open_website()
    {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.traveluro.com/");
        driver.manage().window().maximize();


    }

    @Test (priority = 2)
    void title()
    {
        String title =driver.getTitle();
        if(title.equals("Hotel booking | Traveluro.com"))
        {
            System.out.println("Title is matched");
        }
        else
        {
            System.out.println("Title is not matched");
        }

    }


    @Test (priority = 3)
    void login() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='clickable'][normalize-space()='Login']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='myModalNorm']//input[@id='email']")).sendKeys("parth@splittytravel.com");
        driver.findElement(By.xpath("//div[@id='myModalNorm']//input[@id='password']")).sendKeys("Abcd@1234");
        driver.findElement(By.xpath("//div[@id='myModalNorm']//button[@type='submit'][normalize-space()='Login']")).click();

        Actions act= new Actions(driver);
        WebElement text= driver.findElement(By.xpath("//a[@id='sm-15236008200698604-3']"));
        act.moveToElement(text).perform();

       // List<WebElement> logoutElements = driver.findElements(By.xpath("//a[contains(@class, 'logout-menu')]"));
        if(driver.findElement(By.xpath("//a[contains(@class, 'logout-menu')]")).isDisplayed())
        {
            System.out.println("✅ Login successful" );
        }
        else
        {
            System.out.println("❌ Login failed");
        }


    }

    @Test (priority = 4)
    void logout()
    {
        act= new Actions(driver);
        WebElement logout=driver.findElement(By.xpath("//a[@id='sm-15236008200698604-3']"));
        act.moveToElement(logout).perform();

        driver.findElement(By.xpath("//a[@class='logout-menu']")).click();
    }













}
