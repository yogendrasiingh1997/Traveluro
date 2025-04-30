package Day_38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Headless_testing {
    public  static  void main (String[] args){

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.traveluro.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ChromeOptions options= new ChromeOptions();
        options.addArguments("--incognito"); //incognito mode
        options.addArguments("--headless= new");

        String title= driver.getTitle();

        if(title.equals("Hotel booking | Traveluro.com"))
        {
            System.out.println("Test is passed");
        }
        else
        {
            System.out.println("Test is failed");
        }







    }}
